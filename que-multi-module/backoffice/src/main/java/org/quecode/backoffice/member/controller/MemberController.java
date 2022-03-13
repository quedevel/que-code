package org.quecode.backoffice.member.controller;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.member.service.MemberService;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
}
