package org.quecode.backoffice.member.repository;

import org.quecode.backoffice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * 아이디로 회원 찾기
     * @param mbrId
     * @return Optional<Member>
     */
    Optional<Member> findByMbrId(String mbrId);

    /**
     * 아이디로 회원 삭제
     * @param mbrId
     */
    @Transactional
    void deleteByMbrId(String mbrId);

}
