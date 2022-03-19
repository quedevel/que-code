package org.quecode.common.member.service;

import lombok.RequiredArgsConstructor;
import org.quecode.common.member.entity.Member;
import org.quecode.common.member.dto.MemberDTO;
import org.quecode.common.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * @param memberDTO
     * @return Member
     */
    public Member join(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO.toEntity());
    }

    /**
     * 아이디로 회원 찾기
     * @param mbrId
     * @return Member
     */
    public Member findMemberById(String mbrId) {
        if(StringUtils.hasLength(mbrId)){
            Optional<Member> memberOptional = memberRepository.findByMbrId(mbrId);
            if(memberOptional.isPresent()) return memberOptional.get();
        }
        return null;
    }

    /**
     * 아이디로 회원 삭제
     * @param mbrId
     */
    public void deleteMemberById(String mbrId) {
        memberRepository.deleteByMbrId(mbrId);
    }
}
