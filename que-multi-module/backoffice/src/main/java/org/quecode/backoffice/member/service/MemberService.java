package org.quecode.backoffice.member.service;

import org.quecode.backoffice.member.entity.Member;
import org.quecode.backoffice.member.dto.MemberDTO;

public interface MemberService {

    /**
     * 회원가입
     * @param memberDTO
     */
    Member join(MemberDTO memberDTO);

    /**
     * 아이디로 회원 찾기
     * @param mbrId
     * @return Optional<Member>
     */
    Member findMemberById(String mbrId);


}
