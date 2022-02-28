package org.quecode.backoffice.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.quecode.backoffice.member.entity.Member;

@ToString
@Data
@Builder
public class MemberDTO {

    private Long mbrSn;

    private String mbrId;

    private String mbrPw;

    private String mbrNm;

    public Member toEntity(){
        return Member.builder()
                .mbrSn(mbrSn)
                .mbrId(mbrId)
                .mbrPw(mbrPw)
                .mbrNm(mbrNm)
                .build();
    }
}
