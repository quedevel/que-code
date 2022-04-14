package org.quecode.backoffice.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.quecode.backoffice.common.constants.CommonConstants;
import org.quecode.common.code.dto.CodeDTO;
import org.quecode.common.code.entity.Code;
import org.quecode.common.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CodeTests {

    @Autowired
    private CodeService codeService;

    @Test
    void insertRoot(){
//        CodeDTO codeDTO = CodeDTO.builder()
//                .id(CommonConstants.TREE_ROOT)
//                .parentId(CommonConstants.TREE_ROOT)
//                .codeNm("tree.root")
//                .depth(0).build();
//
//        Code code = codeService.insertCode(codeDTO);
//
//        assertThat(code.getId()).isEqualTo(codeDTO.getId());
    }
}
