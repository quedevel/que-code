package org.quecode.backoffice.member.entity;

import lombok.*;
import org.quecode.backoffice.common.entity.BaseEntity;
import org.quecode.backoffice.member.dto.MemberDTO;

import javax.persistence.*;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "M_MEMBER")
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbrSn;

    @Column(unique = true)
    private String mbrId;

    private String mbrPw;

    private String mbrNm;

    public MemberDTO toDTO(){
        return MemberDTO.builder()
                .mbrSn(mbrSn)
                .mbrId(mbrId)
                .mbrPw(mbrPw)
                .mbrNm(mbrNm)
                .build();
    }
}
