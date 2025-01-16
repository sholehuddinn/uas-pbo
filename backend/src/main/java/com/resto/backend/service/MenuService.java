package com.resto.backend.service;

import com.resto.backend.model.Menu;
import com.resto.backend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/assets/images/";  // Path folder gambar

    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(String id) {
        return menuRepository.findById(id);
    }

    public Menu createMenu(Menu menu, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = saveImage(file); 
            menu.setGambar(fileName);  // Simpan nama file gambar ke dalam database
        }
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Menu menu, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = saveImage(file);  // Menyimpan gambar dan mendapatkan nama file
            menu.setGambar(fileName);  // Simpan nama file gambar ke dalam database
        }
        return menuRepository.save(menu);
    }

    public void deleteMenu(String id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isPresent()) {
            // Menghapus gambar fisik jika ada
            String imagePath = menu.get().getGambar();
            if (imagePath != null && !imagePath.isEmpty()) {
                deleteImage(imagePath);
            }
            menuRepository.deleteById(id);
        }    
    }

    // Fungsi untuk menyimpan gambar
    private String saveImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);

        // Membuat direktori jika belum ada
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Menyimpan file gambar
        Files.write(path, file.getBytes());
        return fileName;  // Mengembalikan nama file untuk disimpan di database
    }

    private void deleteImage(String imageName) {
        Path imagePath = Paths.get(UPLOAD_DIR + imageName);
        File file = new File(imagePath.toString());
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Gambar " + imageName + " berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus gambar " + imageName);
            }
        }
    }
}
