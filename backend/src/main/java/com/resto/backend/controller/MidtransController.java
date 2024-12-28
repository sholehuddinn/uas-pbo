package com.resto.backend.controller;

import com.resto.backend.model.Order;
import com.resto.backend.model.Chekout;
import com.resto.backend.service.MidtransService;
import com.resto.backend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/midtrans")
public class MidtransController {

    @Autowired
    private MidtransService midtransService;
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/create-token")
    public String createTransactionToken(@RequestBody Order order) {
        try {
            return midtransService.createTransactionToken(order);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @PostMapping("/callback")
    public Chekout handleMidtransCallback(@RequestBody Chekout payload) {
        try {
           
            String orderId = payload.getOrder_id();
            String transactionStatus = payload.getTransaction_status();
            
            orderService.updateOrderStatus(orderId, transactionStatus);
            return midtransService.CreateCo( payload);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
