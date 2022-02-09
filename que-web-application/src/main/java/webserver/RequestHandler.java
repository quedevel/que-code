package webserver;

import entity.User;
import util.HttpRequestUtils;
import util.IOUtils;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                System.out.println(user.toString());

                // redirect 필요...
                url = "/index.html";
                DataOutputStream dos = new DataOutputStream(out);
                response302Header(dos, url);
            } else {
                DataOutputStream dos = new DataOutputStream(out);
                byte[] body = Files.readAllBytes(new File("./webapp"+url).toPath());
                response200Header(dos, body.length, contentType);
                responseBody(dos, body);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent, String contentType) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: "+contentType+";charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void response302Header(DataOutputStream dos, String url) {
        try {
            dos.writeBytes("HTTP/1.1 302 OK \r\n");
            dos.writeBytes("Location: " + url + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
