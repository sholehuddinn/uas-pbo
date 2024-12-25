package com.resto.backend.controller;

import com.resto.backend.model.Menu;
import com.resto.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getAllMenu() {
        try {
            return menuService.getAllMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Menu> getMenuById(@PathVariable String id) {
        try {
            return menuService.getMenuById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        try {
            Menu CreatedMenu = menuService.createMenu(menu);
            return CreatedMenu;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable String id, @RequestBody Menu menu) {
        try {
            menu.setId(id);
            return menuService.updateMenu(menu);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable String id) {
        try {
            menuService.deleteMenu(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
