package org.quecode.backoffice.admin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.quecode.backoffice.admin.dto.AdminDTO;
import org.quecode.backoffice.admin.entity.Admin;
import org.quecode.backoffice.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdminTest {

    @Autowired
    private AdminService adminService;

    /**
     * 모든 테스트 시작전에 test123
     */
    @BeforeAll
    void deleteAdmin(){
        String adminId = "test123";
        adminService.deleteByAdminId(adminId);
    }


    @Test
    void join(){
        // given
        AdminDTO dto = AdminDTO.builder().adminNm("test123").adminId("test123").adminPw("test123").build();

        // when
        Admin admin = adminService.join(dto);

        // then
        assertThat(admin.getAdminId()).isEqualTo(dto.getAdminId());
    }
}
