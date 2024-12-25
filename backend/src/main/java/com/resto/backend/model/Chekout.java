/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.resto.backend.model;

/**
 *
 * @author fajar
 */

import com.resto.backend.model.Order;
import com.resto.backend.model.Menu;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "checkout")
public class Chekout {

    private String transaction_id;
    private String order_id;
    private String fraud_status;
    private String payment_type;
    private int gross_amount;
    private int bayar;
    private int kembalian;
    private String transaction_time;

    // Default Constructor
    public Chekout() {}

    // Parameterized Constructor
    public Chekout(String transaction_id, String order_id, String fraud_status, String payment_type, int gross_amount, int bayar) {
        this.transaction_id = transaction_id;
        this.order_id = order_id;
        this.fraud_status = fraud_status;
        this.payment_type = payment_type;
        this.gross_amount = gross_amount;
        this.bayar = bayar;
        this.kembalian = bayar - gross_amount; // Hitung kembalian saat object dibuat
    }

    // Getter and Setter for transaction_id
    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    // Getter and Setter for order_id
    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    // Getter and Setter for fraud_status
    public String getFraud_status() {
        return fraud_status;
    }

    public void setFraud_status(String fraud_status) {
        this.fraud_status = fraud_status;
    }

    // Getter and Setter for payment_type
    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    // Getter and Setter for gross_amount
    public int getGross_amount() {
        return gross_amount;
    }

    public void setGross_amount(int gross_amount) {
        this.gross_amount = gross_amount;
    }

    // Getter and Setter for bayar
    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
        this.kembalian = bayar - this.gross_amount; // Hitung kembalian saat setter dipanggil
    }

    // Getter and Setter for kembalian
    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    // Getter and Setter for transaction_time
    public String getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(String transaction_time) {
        this.transaction_time = transaction_time;
    }
}
