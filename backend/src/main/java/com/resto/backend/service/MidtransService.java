package com.resto.backend.service;

import com.midtrans.Midtrans;
import com.midtrans.httpclient.SnapApi;
import com.midtrans.httpclient.error.MidtransError;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;

@Service
public class MidtransService {
    
    @Value("${midtrans.server-key}")
    private String serverKey;

    @Value("${midtrans.is-production}")
    private boolean isProduction;

    public MidtransService() {
        // Set serverKey dan environment Midtrans global config
        Midtrans.serverKey = this.serverKey; // Ganti dengan serverKey Anda
        Midtrans.isProduction = this.isProduction; // Ubah ke true jika menggunakan environment production
    }

    public String createTransactionToken() throws MidtransError  {
        UUID idRand = UUID.randomUUID();
        Map<String, Object> params = new HashMap<>();

        // Transaction details
        Map<String, String> transactionDetails = new HashMap<>();
        transactionDetails.put("order_id", idRand.toString());
        transactionDetails.put("gross_amount", "265000");

        // Credit card details
        Map<String, String> creditCard = new HashMap<>();
        creditCard.put("secure", "true");

        // Combine params
        params.put("transaction_details", transactionDetails);
        params.put("credit_card", creditCard);

        // Generate transaction token
        return SnapApi.createTransactionToken(params);
    }
    
//    public String getStatusById (String id) {
//        return
//    }
}
