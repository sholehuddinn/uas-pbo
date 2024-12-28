package com.resto.backend.service;

import com.resto.backend.model.Order;
import com.resto.backend.model.OrderItem;
import com.resto.backend.model.Chekout;
import com.resto.backend.repository.CheckoutRepository;

import com.midtrans.Midtrans;
import com.midtrans.httpclient.SnapApi;
import com.midtrans.httpclient.error.MidtransError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;

@Service
public class MidtransService {
    
    @Autowired
    public CheckoutRepository co_repo;
    
    public MidtransService() {
        // Set serverKey dan environment Midtrans global config
        Midtrans.serverKey = "SB-Mid-server-efXF6oGx6czrJuIL5tLp03Rx"; // Ganti dengan serverKey Anda
        Midtrans.isProduction = false; // Ubah ke true jika menggunakan environment production
    }
    
    public String createTransactionToken(Order order) throws MidtransError {
        Map<String, Object> params = new HashMap<>();

        // Transaction details
        Map<String, Object> transaction_details = new HashMap<>();
        if (order.getOrder_id() == null || order.getOrder_id().isEmpty()) {
            throw new IllegalArgumentException("Order ID is missing or invalid.");
        }
        transaction_details.put("order_id", order.getOrder_id());

        // Item details
        List<Map<String, Object>> item_details = new ArrayList<>();
        double totalAmount = 0;

        for (OrderItem item : order.getItem()) {
            Map<String, Object> itemDetail = new HashMap<>();
            itemDetail.put("name", item.getName());
            itemDetail.put("price", item.getPrice());
            itemDetail.put("quantity", item.getQuantity());
            item_details.add(itemDetail);

            totalAmount += item.getPrice() * item.getQuantity();
        }

        // Validasi dan set gross_amount
        if (totalAmount != order.getGross_amount()) {
            throw new IllegalArgumentException("Gross amount does not match the sum of item details.");
        }
        transaction_details.put("gross_amount", totalAmount);

        // Customer details
        Map<String, Object> customer_details = new HashMap<>();
        customer_details.put("first_name", order.getName());

        // Credit card details
        Map<String, Object> credit_card = new HashMap<>();
        credit_card.put("secure", true);

        // Combine params
        params.put("transaction_details", transaction_details);
        params.put("item_details", item_details);
        params.put("customer_details", customer_details);
        params.put("credit_card", credit_card);

        // Generate transaction token
        return SnapApi.createTransactionToken(params);
    }
    
    public Chekout CreateCo(Chekout co) {
        try {
            
            co.setBayar(co.getGross_amount());
            co.setNama_kasir("midtrans");
            co.setTransaction_time(LocalDateTime.now());
            
            return co_repo.save(co);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
