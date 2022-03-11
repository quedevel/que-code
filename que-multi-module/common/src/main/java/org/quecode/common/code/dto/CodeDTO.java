package org.quecode.common.code.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.quecode.common.code.entity.Code;

@ToString
@Data
@Builder
public class CodeDTO {

    private String id;
    private String parentId;
    private String codeNm;
    private int depth;
    private String codeOp1;
    private String codeOp2;
    private String codeOp3;

    public Code toEntity(){
        return Code.builder()
                .id(id)
                .parentId(parentId)
                .codeNm(codeNm)
                .depth(depth)
                .codeOp1(codeOp1)
                .codeOp2(codeOp2)
                .codeOp3(codeOp3)
                .build();
    }

}
