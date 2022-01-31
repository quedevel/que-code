package com.quecode.springvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/vue")
    public String vue(){
        return "vue/index";
    }
}
