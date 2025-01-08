package com.resto.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    // Direktori tempat gambar akan disimpan
    @Value("${image.upload.dir}")
    private String uploadDir;

    // Method untuk upload gambar
    public String uploadImage(MultipartFile file) throws IOException {
        // Cek jika direktori belum ada, buat direktori baru
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        // Tentukan nama file dan path lengkapnya
        String fileName = file.getOriginalFilename();
        Path filePath = path.resolve(fileName);

        // Simpan file ke server
        Files.write(filePath, file.getBytes());

        return fileName; // Kembalikan nama file atau path
    }

    // Method untuk update gambar
    public String updateImage(String oldGambarPath, MultipartFile newFile) throws IOException {
        // Hapus gambar lama jika ada
        if (oldGambarPath != null && !oldGambarPath.isEmpty()) {
            Path oldFilePath = Paths.get(uploadDir + oldGambarPath);
            Files.deleteIfExists(oldFilePath);
        }

        // Upload gambar baru dan perbarui path gambar
        return uploadImage(newFile);
    }

    // Method untuk delete gambar
    public void deleteImage(String gambarPath) throws IOException {
        Path filePath = Paths.get(uploadDir + gambarPath);
        Files.deleteIfExists(filePath);
    }
}
