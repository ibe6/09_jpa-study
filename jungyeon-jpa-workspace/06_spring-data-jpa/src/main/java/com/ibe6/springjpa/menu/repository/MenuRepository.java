package com.ibe6.springjpa.menu.repository;

import com.ibe6.springjpa.menu.entitiy.Menu;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // @Query(value = "SELECT menu_code, menu_name, manu_price, category_price, category_code, orderable_status FROM tbl_menu WHERE menu_price = ?1", nativeQuery = true)
    // @Query(value = "SELECT menu_code, menu_name, menu_price, category_price, category_code, orderable_status FROM tbl_menu WHERE menu_price = :price", nativeQuery = true)
    // List<Menu> findByMenuPrice(int price);

    List<Menu> findByMenuPriceEquals(int Price); // WHERE menuPrice = xxx
    List<Menu> findByMenuPriceGreaterThanEqual(int Price); // WHERE m.menuPrice >= xxx
    List<Menu> findByMenuPriceGreaterThanEqual(int Price, Sort sort); // WHERE m.menuName LIKE '%xx%'
    List<Menu> findByMenuPriceGreaterThanEqualOrderByMenuPriceDesc(int price); // WHERE m.menuPrice >= xxx ORDER BY xxx ASC|DESC

    List<Menu> findByMenuNameContaining(String name); // WHERE m.menuName LIKE '%xx%'

    List<Menu> findByMenuPriceGreaterThanEqualAndMenuNameContaining(int price, String name); // WHERE m.menuPrice >= xxx AND m.menuName LIKE '%xx%'
}
