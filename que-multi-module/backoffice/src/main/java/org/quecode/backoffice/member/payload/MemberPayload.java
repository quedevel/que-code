package org.quecode.backoffice.member.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class MemberPayload {

    private Long mbrSn;

    private String mbrId;

    private String mbrPw;

    private String mbrNm;
}
