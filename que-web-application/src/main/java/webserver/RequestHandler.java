package webserver;

import entity.User;
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            List<String> httpRequestList = new ArrayList<>();

            while(bufferedReader.ready()){
                httpRequestList.add(bufferedReader.readLine());
            }

            // bufferedReader.readLine() 첫번째 라인에 url 주소가 있음
            String url = IOUtils.getUrl(httpRequestList);
            if(url.isEmpty()){
                return;
            }

            int contentLength = IOUtils.getContentLength(httpRequestList);

            Map<String, String> params = new HashMap<>();

            // 회원 가입 url
            if(url.startsWith("/user/create")){
                // Get 요청으로 파라미터가 쿼리스트링으로 넘어올때
                int paramIdx = url.indexOf("?");
                if(paramIdx >= 0){
                    // queryString 추출
                    String queryString = url.substring(paramIdx+1); // ex) userId=quedevel&password=1234&name=kimdongho&email=quedevel%40innotree.com

                    // queryString을 파라미터 맵으로 변경하는 util 제작
                    params = IOUtils.convertQueryStringToMap(queryString);

                    // 회원생성
                    User user = new User(params.get("userId"),params.get("password"),params.get("name"),params.get("email"));

                    System.out.println(user.toString());

                    url = "/user/form.html";
                } else {
                    String str = IOUtils.readData(bufferedReader, contentLength);
                    url = "/user/form.html";
                }
            }


            // contentType 추출
            String contentType = IOUtils.getContentType(httpRequestList);
            if(contentType.isEmpty()){
                return;
            }

            // body에 경로 넣기
            byte[] body = Files.readAllBytes(new File("./webapp"+url).toPath());

            // js, css etc... content_type 맞추기
            DataOutputStream dos = new DataOutputStream(out);
            response200Header(dos, body.length, contentType);
            responseBody(dos, body);
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

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
