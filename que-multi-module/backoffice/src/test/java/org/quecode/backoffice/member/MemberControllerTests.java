package org.quecode.backoffice.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.quecode.common.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
public class MemberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("GET 회원가입 페이지")
    void join() throws Exception {
        mockMvc.perform(get("/member/join"))
                .andExpect(status().isOk());
    }
}
