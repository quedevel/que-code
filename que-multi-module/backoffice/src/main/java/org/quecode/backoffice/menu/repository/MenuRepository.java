package org.quecode.backoffice.menu.repository;

import org.quecode.backoffice.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
