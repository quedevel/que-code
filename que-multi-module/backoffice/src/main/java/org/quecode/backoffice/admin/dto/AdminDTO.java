package org.quecode.backoffice.admin.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.quecode.backoffice.admin.entity.Admin;

@ToString
@Data
@Builder
public class AdminDTO {

    private Long adminSn;

    private String adminId;

    private String adminPw;

    private String adminNm;

    public Admin toEntity(){
        return Admin.builder()
                .adminSn(adminSn)
                .adminId(adminId)
                .adminPw(adminPw)
                .adminNm(adminNm)
                .build();
    }
}
