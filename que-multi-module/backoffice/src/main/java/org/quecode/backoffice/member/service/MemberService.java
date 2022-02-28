package org.quecode.backoffice.member.service;

import org.quecode.backoffice.member.entity.Member;
import org.quecode.backoffice.member.dto.MemberDTO;

import java.util.Optional;

public interface MemberService {

    /**
     * 회원가입
     * @param memberDTO
     */
    void join(MemberDTO memberDTO);

    /**
     * 아이디로 회원 찾기
     * @param mbrId
     * @return Optional<Member>
     */
    Optional<Member> findMemberById(String mbrId);


}
