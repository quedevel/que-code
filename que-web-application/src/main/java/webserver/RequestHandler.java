package webserver;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class RequestHandler extends Thread {

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        System.out.println("New Client Connect! Connected IP : {"+ connection.getInetAddress()+"}, Port : {"+connection.getPort()+"}");

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {

            // http 요청 정보 가져오기
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // bufferedReader.readLine() 첫번째 라인에 url 주소가 있음
            String url = bufferedReader.readLine().split(" ")[1];
            String contentType = "";
            System.out.println("0  "+url);
            int idx = 1;
            while (bufferedReader.ready()){
                String temp = bufferedReader.readLine();
                if(temp.indexOf("Accept") >= 0){
                    contentType = temp.split(",")[0].split(" ")[1];
                    break;
                }
            }

            DataOutputStream dos = new DataOutputStream(out);

            // body에 경로 넣기
            byte[] body = Files.readAllBytes(new File("./webapp"+url).toPath());

            // js, css etc... content_type 맞추기
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
