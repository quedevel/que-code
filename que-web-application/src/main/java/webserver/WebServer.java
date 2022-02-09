package webserver;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static final int DEFAULT_PORT = 8080;

    // 실행하면 서버 켜짐
    public static void main(String args[]) throws Exception {
        int port = 0;
        if (args == null || args.length == 0) {
            port = DEFAULT_PORT;
        } else {
            port = Integer.parseInt(args[0]);
        }

        // 서버소켓을 생성한다.
        // 8080번 포트를 사용
        try (ServerSocket listenSocket = new ServerSocket(port)) {
            System.out.println("Web Application Server started {} port.... "+ port);

            // 클라이언트가 연결될때까지 대기
            Socket connection;
            while ((connection = listenSocket.accept()) != null) {
                RequestHandler requestHandler = new RequestHandler(connection);
                requestHandler.start();
            }
        }
    }
}
