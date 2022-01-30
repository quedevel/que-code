package com.quecode.swagger.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Swagger Controller"})
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @GetMapping("/hello")
    public String hell(){
        return "hell world...";
    }
}
