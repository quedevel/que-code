package org.quecode.backoffice.menu.service;

import lombok.RequiredArgsConstructor;
import org.quecode.backoffice.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;
}
