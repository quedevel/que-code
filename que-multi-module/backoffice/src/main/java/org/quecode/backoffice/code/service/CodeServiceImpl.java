package org.quecode.backoffice.code.service;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.code.repository.CodeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;
}
