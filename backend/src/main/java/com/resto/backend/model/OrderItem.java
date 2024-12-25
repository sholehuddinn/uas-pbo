package com.resto.backend.model;

public class OrderItem {
    private String productId;
    private String name;
    private int quantity;
    private int price;
    private int total;
    private String[] variant;
    
    public OrderItem() {}
    
    public OrderItem(String ProductId, String Name, int qty, int Price, int Total, String[] varr) {
        this.productId = ProductId;
        this.name = Name;
        this.quantity = qty;
        this.price = Price;
        this.total = Total;
        this.variant = varr;
    }

    // Getter and Setter
    public String getProductId() {
        return productId;
    }
    
    public void setProductId (String ProductId) {
        this.productId = ProductId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String Name) {
        this.name = Name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int Price) {
        this.price = Price;
    }
    
    public String[] getVariant () {
        return variant;
    }
    
    public void setVariant(String[] varr) {
        this.variant = varr;
    }
    
    public int getTotal () {
        return total;
    }
    
    public void setTotal(int Total) {
        this.total = Total;
    }
}
