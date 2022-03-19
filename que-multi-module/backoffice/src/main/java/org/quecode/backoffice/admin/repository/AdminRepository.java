package org.quecode.backoffice.admin.repository;

import org.quecode.backoffice.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
