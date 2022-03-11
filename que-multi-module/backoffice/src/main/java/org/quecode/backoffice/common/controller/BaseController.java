package org.quecode.backoffice.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/index")
    public void index() {

    }

    @GetMapping("/")
    public String defaultPath(){
        return "redirect:/index";
    }

    @GetMapping("/error/401")
    public void error401(){

    }

    @GetMapping("/error/404")
    public void error404(){

    }

    @GetMapping("/error/500")
    public void error500(){

    }
}
