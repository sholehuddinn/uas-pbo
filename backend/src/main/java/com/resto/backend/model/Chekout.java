/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.resto.backend.model;

/**
 *
 * @author fajar
 */


import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "checkout")
public class Chekout {

    @Id
    private String transaction_id;
    private String order_id;
    private String fraud_status;
    private String payment_type;
    private String transaction_status;
    private String nama_kasir;
    private int gross_amount;
    private int bayar;
    private int kembalian;
    private LocalDateTime transaction_time;

    public Chekout() {}

    public Chekout(String transaction_id, String order_id, String fraud_status, String payment_type, String Status, String namakasir, int gross_amount, int bayar, LocalDateTime time) {
        this.transaction_id = transaction_id;
        this.order_id = order_id;
        this.fraud_status = fraud_status;
        this.payment_type = payment_type;
        this.nama_kasir = namakasir;
        this.transaction_status = Status;
        this.gross_amount = gross_amount;
        this.bayar = bayar;
        this.kembalian = bayar - gross_amount; 
        this.transaction_time = time;
    }

    public String getTransaction_id() {
        return transaction_id;
    }
    
    public String getNama_kasir() {
        return nama_kasir;
    }
    
    public void setNama_kasir(String name) {
        this.nama_kasir = name;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getFraud_status() {
        return fraud_status;
    }

    public void setFraud_status(String fraud_status) {
        this.fraud_status = fraud_status;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public int getGross_amount() {
        return gross_amount;
    }

    public void setGross_amount(int gross_amount) {
        this.gross_amount = gross_amount;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
        this.kembalian = bayar - this.gross_amount; 
    }

    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    public LocalDateTime getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(LocalDateTime transaction_time) {
        this.transaction_time = transaction_time;
    }
    
    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }
}
