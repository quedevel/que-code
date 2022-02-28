package org.quecode.backoffice.member.service;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.common.mapper.CustomModelMapper;
import org.quecode.backoffice.member.entity.Member;
import org.quecode.backoffice.member.dto.MemberDTO;
import org.quecode.backoffice.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * @param memberDTO
     */
    @Override
    public void join(MemberDTO memberDTO) {
        CustomModelMapper modelMapper = new CustomModelMapper();
        Member member = modelMapper.map(memberDTO, Member.class);
        memberRepository.save(member);
    }

    /**
     * 아이디로 회원 찾기
     * @param mbrId
     * @return Optional<Member>
     */
    public Optional<Member> findMemberById(String mbrId) {
        if(StringUtils.hasLength(mbrId)){
            return memberRepository.findByMbrId(mbrId);
        }
        return Optional.empty();
    }
}
