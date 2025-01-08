package com.resto.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
public class Menu {
    @Id
    private String id;
    private String namaMenu;
    private String category;
    private String gambar;
    private double harga;
    
    public Menu() {}

    public Menu(String id, String namaMenu,String category, String gambar, double harga) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.category = category;
        this.gambar = gambar;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String Eat) {
        this.category = Eat;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}


