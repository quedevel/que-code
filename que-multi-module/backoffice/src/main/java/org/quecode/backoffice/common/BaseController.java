package org.quecode.backoffice.common;

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
}
