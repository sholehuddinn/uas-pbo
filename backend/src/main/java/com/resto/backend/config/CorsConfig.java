package com.resto.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Konfigurasi global CORS untuk seluruh aplikasi
        registry.addMapping("/**")  // Mengizinkan semua endpoint (rute)
                .allowedOrigins("http://localhost:5173")  // Menambahkan origin yang diizinkan (misalnya frontend React)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Menambahkan metode HTTP yang diizinkan
                .allowedHeaders("*")  // Mengizinkan semua header
                .allowCredentials(true);  // Mengizinkan penggunaan cookies atau kredensial lainnya
    }
}
