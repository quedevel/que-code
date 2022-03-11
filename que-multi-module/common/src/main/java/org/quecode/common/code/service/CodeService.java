package org.quecode.common.code.service;

import lombok.RequiredArgsConstructor;
import org.quecode.common.code.repository.CodeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CodeService {

    private final CodeRepository codeRepository;
}
