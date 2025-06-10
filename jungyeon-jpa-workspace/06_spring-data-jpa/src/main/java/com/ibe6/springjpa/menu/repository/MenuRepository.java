package com.ibe6.springjpa.menu.repository;

import com.ibe6.springjpa.menu.entitiy.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
