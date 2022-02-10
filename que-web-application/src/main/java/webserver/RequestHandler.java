package webserver;

import constants.CommonConstants;
import db.DataBase;
import entity.User;
import util.HttpRequestUtils;
import util.IOUtils;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.*;

public class RequestHandler extends Thread {

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        System.out.println("New Client Connect! Connected IP : {"+ connection.getInetAddress()+"}, Port : {"+connection.getPort()+"}");

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {

            // http 요청 정보 가져오기
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            List<String> httpRequestList = new ArrayList<>();

            String readLine = bufferedReader.readLine();

            if(!"".equals(readLine)) httpRequestList.add(readLine);

            // bufferedReader.readLine() 첫번째 라인에 url 주소가 있음
            String url = readLine.split(" ")[1];
            if(url.isEmpty()){
                return;
            }

            // 모든 정보 리스트에 넣기
            while(!"".equals(readLine)){
                readLine = bufferedReader.readLine();
                if(!"".equals(readLine)) httpRequestList.add(readLine);
            }

            // 모든 요청정보 추출
            httpRequestList.forEach(System.out::println);

            // contentType 추출
            String contentType = IOUtils.getContentType(httpRequestList);
            if(contentType.isEmpty()){
                return;
            }

            // 컨텐츠 길이 추출
            int contentLength = IOUtils.getContentLength(httpRequestList);

            Map<String, String> params = new HashMap<>();

            // 회원 가입 url
            if(url.startsWith("/user/create")){
                // post 요청
                // content body 제일 마지막에 넘어온 query string 읽기
                String queryString = IOUtils.readData(bufferedReader, contentLength);
                params = HttpRequestUtils.parseQueryString(queryString);
                // 회원생성
                User user = new User(params.get("userId"),params.get("password"),params.get("name"),params.get("email"));

                // 저장 ( 임의로 전역변수에 저장 )
                DataBase.addUser(user);

                // redirect 필요...
                response302Header(out, CommonConstants.INDEX_URL);
            } else if ("/user/login".equals(url)) {
                // login 정보 읽기
                String queryString = IOUtils.readData(bufferedReader, contentLength);
                params = HttpRequestUtils.parseQueryString(queryString);
                // user 조회
                User user = DataBase.findUserById(params.get("userId"));

                // user 존재 여부 검사
                if(Objects.isNull(user)){
                    System.out.println("등록된 유저가 없음.");
                    // 로그인 실패
                    response200Header(out, contentType, CommonConstants.LOGIN_FAIL_URL);
                }

                // 로그인 성공 여부
                if(user.getPassword().equals(params.get("password"))){
                    // 로그인 성공
                    response302HeaderWithCookie(out);
                } else {
                    System.out.println("비밀번호 틀렸다잉");
                    // 로그인 실패
                    response200Header(out, contentType, CommonConstants.LOGIN_FAIL_URL);
                }
            } else {
                response200Header(out, contentType, url);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void response302HeaderWithCookie(OutputStream outputStream) throws IOException{
        DataOutputStream dos =new DataOutputStream(outputStream);
        dos.writeBytes("HTTP/1.1 302 OK \r\n");
        dos.writeBytes("Set-Cookie: isLogin=true \r\n");
        dos.writeBytes("Location : "+CommonConstants.INDEX_URL+"\r\n");
        dos.writeBytes("\r\n");
    }

    private void response302Header(OutputStream outputStream, String url) throws IOException {
        DataOutputStream dos =new DataOutputStream(outputStream);
        dos.writeBytes("HTTP/1.1 302 OK \r\n");
        dos.writeBytes("Location: " + url + "\r\n");
        dos.writeBytes("\r\n");
    }

    private void response200Header(OutputStream outputStream, String contentType, String url) throws IOException {
        DataOutputStream dos =new DataOutputStream(outputStream);
        byte[] body = Files.readAllBytes(new File("./webapp"+url).toPath());
        dos.writeBytes("HTTP/1.1 200 OK \r\n");
        dos.writeBytes("Content-Type: "+contentType+";charset=utf-8\r\n");
        dos.writeBytes("Content-Length: " + body.length + "\r\n");
        dos.writeBytes("\r\n");
        responseBody(dos, body);
    }

    private void responseBody(DataOutputStream dos, byte[] body) throws IOException {
        dos.write(body, 0, body.length);
        dos.flush();
    }
}
