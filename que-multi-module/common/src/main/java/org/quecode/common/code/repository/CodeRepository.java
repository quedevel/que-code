package org.quecode.common.code.repository;

import org.quecode.common.code.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, String> {

}
