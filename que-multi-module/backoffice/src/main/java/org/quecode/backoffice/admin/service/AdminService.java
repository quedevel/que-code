package org.quecode.backoffice.admin.service;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.admin.dto.AdminDTO;
import org.quecode.backoffice.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void join(AdminDTO adminDTO){

    }
}
