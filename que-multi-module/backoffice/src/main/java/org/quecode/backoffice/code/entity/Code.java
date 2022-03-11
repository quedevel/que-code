package org.quecode.backoffice.code.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.quecode.backoffice.code.dto.CodeDTO;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "M_CODE")
@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String parentId;
    private String codeNm;
    private int depth;
    private String codeOp1;
    private String codeOp2;
    private String codeOp3;

    public CodeDTO toDTO(){
        return CodeDTO.builder()
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
