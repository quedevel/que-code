package org.quecode.backoffice.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quecode.backoffice.admin.dto.AdminDTO;
import org.quecode.backoffice.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void join(AdminDTO adminDTO){
        log.info("join() called with: adminDTO = [" + adminDTO + "]");
    }
}
