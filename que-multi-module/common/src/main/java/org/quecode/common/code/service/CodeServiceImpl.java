package org.quecode.common.code.service;

import lombok.RequiredArgsConstructor;
import org.quecode.common.code.repository.CodeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;
}
