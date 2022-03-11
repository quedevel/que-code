package org.quecode.backoffice.code.controller;

import lombok.RequiredArgsConstructor;
import org.quecode.common.code.service.CodeService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CodeApiController {

    private final CodeService codeService;
}
