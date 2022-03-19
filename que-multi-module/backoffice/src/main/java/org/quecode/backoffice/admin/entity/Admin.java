package org.quecode.backoffice.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.quecode.backoffice.admin.dto.AdminDTO;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "M_ADMIN")
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminSn;

    @Column(unique = true)
    private String adminId;

    private String adminPw;

    private String adminNm;

    public AdminDTO toDTO(){
        return AdminDTO.builder()
                .adminSn(adminSn)
                .adminId(adminId)
                .adminPw(adminPw)
                .adminNm(adminNm)
                .build();
    }
}
