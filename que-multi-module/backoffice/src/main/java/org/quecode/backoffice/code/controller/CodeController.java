package org.quecode.backoffice.code.controller;

import lombok.RequiredArgsConstructor;
import org.quecode.common.code.service.CodeService;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class CodeController {

    private final CodeService codeService;
}
