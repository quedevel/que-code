package org.quecode.backoffice.member;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.quecode.backoffice.member.dto.MemberDTO;
import org.quecode.backoffice.member.entity.Member;
import org.quecode.backoffice.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberService memberService;

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
