package com.resto.backend.model;

import com.resto.backend.model.OrderItem;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
    @Id
    private String orderId;
    private String name;
    private String kursi;
    private String catatan;
    private String status;
    private OrderItem[] item; // OrderItem menjadi objek biasa
    private int gross_amount;
    
    public Order() {}
    
    public Order(String orderId, String Name, String Kursi, String Catatan, OrderItem[] order, int Gross_amount) {
        this.orderId = orderId;
        this.name = Name;
        this.kursi = Kursi;
        this.catatan = Catatan;
        this.item = order;
        this.gross_amount = Gross_amount;
    }

    // Getter and Setter
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
