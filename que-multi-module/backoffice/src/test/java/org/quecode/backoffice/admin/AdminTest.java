package org.quecode.backoffice.admin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.quecode.backoffice.admin.dto.AdminDTO;
import org.quecode.backoffice.admin.entity.Admin;
import org.quecode.backoffice.admin.service.AdminService;
import org.quecode.backoffice.common.constants.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdminTest {

    @Autowired
    private AdminService adminService;

    /**
     * 모든 테스트 시작전에 test123 제거
     */
    @BeforeAll
    void deleteAdmin(){
        String adminId = "test123";
        //adminService.deleteByAdminId(adminId);
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

    @Test
    void selectTest(){
        Page<Admin> adminList = adminService.selectAdminList(Pageable.unpaged());
        int totalPages = adminList.getTotalPages();

        System.out.println("totalPages = " + totalPages);

        List<Admin> adminListContent = adminList.getContent();

        adminListContent.stream().map(Admin::getAdminId).forEach(System.out::println);
    }

    @Test
    void selectTest2(){
        Pageable pageable = Pageable.ofSize(CommonConstants.DEFAULT_PAGE_SIZE);

        Page<Admin> adminList = adminService.selectAdminList(pageable);

        int totalPages = adminList.getTotalPages();

        System.out.println("totalPages = " + totalPages);


    }

    @Test
    void insertDummyAdmin(){
//        IntStream.range(1,31).forEach(i-> {
//            AdminDTO dto = AdminDTO.builder()
//                    .adminId("dummy"+i)
//                    .adminNm("dummy"+i)
//                    .adminPw("dummy"+i)
//                    .build();
//
//            adminService.join(dto);
//        });
    }
}
