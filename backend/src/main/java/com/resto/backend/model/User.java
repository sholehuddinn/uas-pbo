/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.resto.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    private String name;
    private String username;
    private String password;
    
    public User() {}
    
    public User(String Name, String Pass, String us) {
        this.name = Name;
        this.password = Pass;
        this.username = us;
    }
    
    public void setName(String Name) {
        this.name = Name;
    }
    
    public void setUsername(String Username) {
        this.username = Username;
    }
    
    public void setPassword(String Pass) {
        this.password = Pass;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
}
