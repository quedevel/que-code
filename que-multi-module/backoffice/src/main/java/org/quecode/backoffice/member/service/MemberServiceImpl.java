package org.quecode.backoffice.member.service;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.member.entity.Member;
import org.quecode.backoffice.member.dto.MemberDTO;
import org.quecode.backoffice.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * @param payload
     */
    @Override
    public void join(MemberDTO payload) {

    }

    /**
     * 아이디로 회원 찾기
     * @param mbrId
     * @return Member
     */
    @Override
    public Member findMemberById(String mbrId) {
        return null;
    }
}
