package com.resto.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {

    @Id
    private String id;
    private String name;
    private String kursi;
    private String catatan;
    private String status;
    private OrderItem[] item; 
    private int gross_amount;
    
    public Order() {}
    
    public Order(String OrderId, String Name, String Kursi, String Catatan, OrderItem[] order, int Gross_amount) {
        this.id = OrderId;
        this.name = Name;
        this.kursi = Kursi;
        this.catatan = Catatan;
        this.item = order;
        this.gross_amount = Gross_amount;
    }
    
    public String getOrder_id() {
        return id;
    }
    
    public void setOrder_id(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String Name) {
        this.name = Name;
    }

    public OrderItem[] getItem() {
        return item;
    }

    public void setItem(OrderItem[] item) {
        this.item = item;
    }

    public String getKursi() {
        return kursi;
    }

    public void setKursi(String kursi) {
        this.kursi = kursi;
    }
    
    public String getCatatan() {
        return catatan;
    }
    
    public void setCatatan(String Catatan) {
        this.catatan = Catatan;
    }
    
    public void setStatus(String Status) {
        this.status = (Status != null && !Status.isEmpty()) ? Status : "pending";
    }
    
    public String getStatus () {
        return status;
    }
    
    public void setGross_amount(int Gross_amount){
        this.gross_amount = Gross_amount;
    }
    
    public int getGross_amount() {
        return gross_amount;
    }
}
