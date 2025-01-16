package com.resto.backend.controller;

import com.resto.backend.model.Menu;
import com.resto.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Menu createMenu(@RequestParam("name") String name,
                           @RequestParam("price") Double price,
                           @RequestParam("category") String category,
                           @RequestParam(value = "image", required = false) MultipartFile file) {
        try {
            Menu menu = new Menu();
            menu.setNamaMenu(name);
            menu.setHarga(price);
            menu.setCategory(category);
            return menuService.createMenu(menu, file);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable String id,
                           @RequestParam("name") String name,
                           @RequestParam("price") Double price,
                           @RequestParam(value = "image", required = false) MultipartFile file) {
        try {
            Optional<Menu> existingMenu = menuService.getMenuById(id);
            if (existingMenu.isPresent()) {
                Menu menu = existingMenu.get();
                menu.setNamaMenu(name);
                menu.setHarga(price);
                return menuService.updateMenu(menu, file);
            }
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
