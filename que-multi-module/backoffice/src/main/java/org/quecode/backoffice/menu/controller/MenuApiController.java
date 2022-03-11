package org.quecode.backoffice.menu.controller;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.menu.service.MenuService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MenuApiController {

    private final MenuService menuService;
}
