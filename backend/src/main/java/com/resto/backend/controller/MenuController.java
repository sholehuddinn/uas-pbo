package com.resto.backend.controller;

import com.resto.backend.model.Menu;
import com.resto.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
@Tag(name = "Menu Controller", description = "Manajemen menu restoran")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    @Operation(summary = "Ambil semua menu", description = "Mengembalikan daftar semua menu restoran")
    public List<Menu> getAllMenu() {
        try {
            return menuService.getAllMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ambil menu berdasarkan ID", description = "Mengembalikan menu berdasarkan ID")
    public Optional<Menu> getMenuById(@PathVariable String id) {
        try {
            return menuService.getMenuById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @PostMapping
    @Operation(summary = "Membuat menu baru", description = "Membuat menu baru dengan gambar jika ada")
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
    @Operation(summary = "Perbarui menu berdasarkan ID", description = "Memperbarui menu dengan gambar baru jika ada")
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
    @Operation(summary = "Hapus menu berdasarkan ID", description = "Menghapus menu berdasarkan ID")
    public void deleteMenu(@PathVariable String id) {
        try {
            menuService.deleteMenu(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
