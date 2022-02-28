package org.quecode.backoffice.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class MemberDTO {

    private Long mbrSn;

    private String mbrId;

    private String mbrPw;

    private String mbrNm;
}
