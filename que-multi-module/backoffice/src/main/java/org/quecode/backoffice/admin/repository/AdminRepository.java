package org.quecode.backoffice.admin.repository;

import org.quecode.backoffice.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByAdminId(String username);

    @Transactional
    void deleteByAdminId(String adminId);

}
