package org.quecode.backoffice.admin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.quecode.backoffice.admin.dto.AdminDTO;
import org.quecode.backoffice.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @BeforeEach
    void deleteAdmin(){
        String adminId = "test123";
        adminService.deleteByAdminId(adminId);
    }


    @Test
    void join(){
        adminService.join(AdminDTO.builder().build());
    }
}
