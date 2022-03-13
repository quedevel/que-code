package org.quecode.backoffice.member.controller;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/member/join")
    public void join(){
        System.out.println("get join.....");
    }
}
