package org.quecode.backoffice.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quecode.backoffice.admin.dto.AdminDTO;
import org.quecode.backoffice.admin.entity.Admin;
import org.quecode.backoffice.admin.repository.AdminRepository;
import org.quecode.backoffice.common.contants.ErrorCode;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void join(AdminDTO adminDTO){
        log.info("join() called with: adminDTO = [" + adminDTO + "]");
    }

    public void login(AdminDTO adminDTO){
        log.info("login() called with: adminDTO = [" + adminDTO + "]");
    }

    public Admin getAdminByUsername(String username){
        log.info("getAdminByUsername() called with: username = [" + username + "]");
        Optional<Admin> optionalAdmin = adminRepository.findByAdminId(username);
        if(optionalAdmin.isEmpty()){
            throw new UsernameNotFoundException(ErrorCode.USERNAME_OR_PASSWORD_NOT_FOUND_EXCEPTION.getMessage());
        }
        return optionalAdmin.get();
    }
}
