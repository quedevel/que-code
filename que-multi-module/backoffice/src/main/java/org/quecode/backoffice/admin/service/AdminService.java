package org.quecode.backoffice.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quecode.backoffice.admin.dto.AdminDTO;
import org.quecode.backoffice.admin.entity.Admin;
import org.quecode.backoffice.admin.repository.AdminRepository;
import org.quecode.backoffice.common.contants.ErrorCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    /**
     * 관리자 회원가입
     * @param adminDTO
     */
    public Admin join(AdminDTO adminDTO){
        log.info("join() called with: adminDTO = [" + adminDTO + "]");
        // todo validation
        return adminRepository.save(adminDTO.toEntity());
    }

    /**
     * 관리자 삭제 by adminId
     * @param adminId
     */
    public void deleteByAdminId(String adminId){
        log.info("deleteByAdminId() called with: adminId = [" + adminId + "]");
        adminRepository.deleteByAdminId(adminId);
    }

    /**
     * 관리자 조회
     * @param pageable
     * @return Page<Admin>
     */
    public Page<Admin> selectAdminList(Pageable pageable){
        log.info("selectAdminList() called with: pageable = [" + pageable + "]");
        return adminRepository.findAll(pageable);
    }

    /**
     * 관리자 조회 by username
     * @param username
     * @return Admin
     */
    public Admin getAdminByUsername(String username){
        log.info("getAdminByUsername() called with: username = [" + username + "]");
        Optional<Admin> optionalAdmin = adminRepository.findByAdminId(username);
        if(optionalAdmin.isEmpty()){
            throw new UsernameNotFoundException(ErrorCode.USERNAME_OR_PASSWORD_NOT_FOUND_EXCEPTION.getMessage());
        }
        return optionalAdmin.get();
    }

}
