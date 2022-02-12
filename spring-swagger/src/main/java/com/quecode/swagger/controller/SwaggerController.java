package com.quecode.swagger.controller;

import com.quecode.swagger.entity.Member;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

// @Api: 해당 컨트롤러에 내용을 설정
@Api(tags = {"SwaggerController"})
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @GetMapping("/hello")
    public String hell(){
        return "hell world...";
    }

    // @ApiImpicitParams: 컨트롤러에 매핑될 파라미터들에 설정
    @ApiImplicitParams({
            // @ApiImpicitParam: 매핑될 파라미터 하나의 내용을 설정
            @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path")
            , @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(@PathVariable int x, @RequestParam int y){
        return x + y;
    }

    // @ApiResponse: 응답 코드에 대한 설명
    // @ApiOperation: 매핑 메소드에 대한 설명
    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
    @GetMapping("/user")
    public Member member(Member member){
        return new Member(member.getMbrNm(), member.getAge());
    }

    @PostMapping("/user")
    public Member memberPost(@RequestBody Member member){
        return new Member(member.getMbrNm(), member.getAge());
    }

}
