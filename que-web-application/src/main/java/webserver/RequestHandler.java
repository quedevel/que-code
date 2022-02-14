package webserver;

import constants.CommonConstants;
import controller.Controller;
import http.HttpRequest;
import http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;

import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.HttpRequestUtils;
import db.DataBase;

public class RequestHandler extends Thread {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(), connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            HttpRequest request = new HttpRequest(in);
            HttpResponse response = new HttpResponse(out);
            String path = getDefaultPath(request.getPath());

            Controller controller = RequestMapping.getController(path);

            // 매핑된 컨트롤러 여부 확인
            if (controller != null) {
                controller.service(request, response);
            } else {
                response.forward(path);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    /**
     * default url
     * @param path
     * @return
     */
    private String getDefaultPath(String path) {
        if (path.equals("/")) {
            return CommonConstants.INDEX_URL;
        }
        return path;
    }
}