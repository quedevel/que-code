package org.quecode.backoffice.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(){
        log.info("getLogin() called");
        return "/login/login";
    }

    @PostMapping("/login")
    public String postLogin(){
        log.info("postLogin() called");
        return "/login/login";
    }

}
