package org.quecode.backoffice.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.quecode.backoffice.common.entity.BaseEntity;

import javax.persistence.*;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "M_MEMBER", uniqueConstraints = {@UniqueConstraint(name = "MBR_ID_UNIQUE", columnNames = {"MBR_ID"})})
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbrSn;

    private String mbrId;

    private String mbrPw;

    private String mbrNm;
}
