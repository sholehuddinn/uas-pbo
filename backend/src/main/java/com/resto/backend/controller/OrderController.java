/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.resto.backend.controller;

/**
 *
 * @author fajar
 */

import com.resto.backend.model.Order;
import com.resto.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable String id) {
        try {
            return orderService.getOrderById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @PostMapping
    public Order createOrder(@RequestBody Order Order) {
        try {
            Order CreatedOrder = orderService.createOrder(Order);
            return CreatedOrder;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<Order[]> getOrderPending(@PathVariable String status) {
        // Mengambil daftar pesanan berdasarkan status
        Order[] orders = orderService.getOrderByStatus(status);
        
        // Jika tidak ada pesanan dengan status tersebut
        if (orders.length == 0) {
            return ResponseEntity.noContent().build(); 
        }
        // Mengembalikan daftar pesanan dengan status tersebut
        return ResponseEntity.ok(orders);
    }
    
    
    
}
