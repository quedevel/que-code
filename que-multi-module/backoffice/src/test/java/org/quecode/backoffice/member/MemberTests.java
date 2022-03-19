package org.quecode.backoffice.member;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.quecode.common.member.dto.MemberDTO;
import org.quecode.common.member.entity.Member;
import org.quecode.common.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTests {

    @Autowired
    private MemberService memberService;

    @BeforeEach
    void deleteTestMember(){
        String mbrId = "test123";
        memberService.deleteMemberById(mbrId);
    }

    @Test
    @DisplayName("회원 가입 테스트")
    void join(){
        // given
        MemberDTO dto = MemberDTO.builder().mbrId("test123").mbrPw("1234").mbrNm("timekiller").build();
        Member member = memberService.join(dto);

        // when
        String mbrId = "test123";
        Member findMember = memberService.findMemberById(mbrId);

        // then
        assertThat(member.getMbrId()).isEqualTo(findMember.getMbrId());
    }
}
