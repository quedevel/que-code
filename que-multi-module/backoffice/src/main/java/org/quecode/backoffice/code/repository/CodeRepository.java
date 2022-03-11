package org.quecode.backoffice.code.repository;

import org.quecode.backoffice.code.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, String> {

}
