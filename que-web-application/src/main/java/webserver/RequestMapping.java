package webserver;

import controller.Controller;
import controller.CreateUserController;
import controller.ListUserController;
import controller.LoginController;

import java.util.HashMap;
import java.util.Map;

/**
 * 서블릿 컨터이너 역할
 * > 서블릿 클래스의 인스턴스 생성, 요청 URL과 서블릿 인스턴스 매핑,
 *   클라이언트 요청에 해당하는 서블릿을 찾은 후 서블릿에 작업을 위임하는 역할
 */
public class RequestMapping {

    private static Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/user/create", new CreateUserController());
        controllers.put("/user/login", new LoginController());
        controllers.put("/user/list", new ListUserController());
    }

    public static Controller getController(String requestUrl){
        return controllers.get(requestUrl);
    }
}
