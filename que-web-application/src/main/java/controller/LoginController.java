package controller;

import constants.CommonConstants;
import db.DataBase;
import http.HttpRequest;
import http.HttpResponse;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginController implements Controller{

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        User user = DataBase.findUserById(request.getParameter("userId"));
        if (user != null) {
            if (user.login(request.getParameter("password"))) {
                response.addHeader("Set-Cookie", "isLogined=true; Path=/");
                response.sendRedirect(CommonConstants.INDEX_URL);
            } else {
                response.sendRedirect(CommonConstants.LOGIN_FAIL_URL);
            }
        } else {
            response.sendRedirect(CommonConstants.LOGIN_FAIL_URL);
        }
    }
}
