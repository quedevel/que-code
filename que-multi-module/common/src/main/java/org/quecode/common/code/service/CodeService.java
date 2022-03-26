package org.quecode.common.code.service;

import lombok.RequiredArgsConstructor;
import org.quecode.common.code.dto.CodeDTO;
import org.quecode.common.code.entity.Code;
import org.quecode.common.code.repository.CodeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CodeService {

    private final CodeRepository codeRepository;

    public Code insertCode(CodeDTO codeDTO){
        return codeRepository.save(codeDTO.toEntity());
    }
}
