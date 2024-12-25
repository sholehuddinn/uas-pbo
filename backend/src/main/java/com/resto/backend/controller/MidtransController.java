package com.resto.backend.controller;

import com.resto.backend.service.MidtransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/midtrans")
public class MidtransController {

    @Autowired
    private MidtransService midtransService;

    @GetMapping("/create-token")
    public String createTransactionToken() {
        try {
            return midtransService.createTransactionToken();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
