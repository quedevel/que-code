package com.quecode.swagger.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"SwaggerController"})
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    // @Api: 해당 컨트롤러에 내용을 설정
    // @ApiImpicitParams: 컨트롤러에 매핑될 파라미터들에 설정
    // @ApiImpicitParam: 매핑될 파라미터 하나의 내용을 설정
    // @ApiResponse: 응답 코드에 대한 설명
    // @ApiOperation: 매핑 메소드에 대한 설명

    @GetMapping("/hello")
    public String hell(){
        return "hell world...";
    }


}
