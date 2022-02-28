package org.quecode.backoffice.member.service;

import org.quecode.backoffice.member.entity.Member;
import org.quecode.backoffice.member.dto.MemberDTO;

public interface MemberService {

    /**
     * 회원가입
     * @param payload
     */
    void join(MemberDTO payload);

    /**
     * 아이디로 회원 찾기
     * @param mbrId
     * @return Member
     */
    Member findMemberById(String mbrId);


}
