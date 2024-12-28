package com.resto.backend.controller;


import com.resto.backend.service.CashService;
import com.resto.backend.model.Chekout;
import com.resto.backend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CashController {

    @Autowired
    private CashService cashService;
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Chekout createData(@RequestBody Chekout checkoutRequest) {
        try {
            
            orderService.updateOrderStatus(checkoutRequest.getOrder_id(), checkoutRequest.getTransaction_status());
            
            return cashService.createData(checkoutRequest);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
}
