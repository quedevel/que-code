package org.quecode.backoffice.menu.controller;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.menu.service.MenuService;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MenuController {

    private final MenuService menuService;
}
