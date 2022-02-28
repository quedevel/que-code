package org.quecode.backoffice.member.repository;

import org.quecode.backoffice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
