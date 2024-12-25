/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.resto.backend.service;

/**
 *
 * @author fajar
 */

import com.resto.backend.model.Order;
import com.resto.backend.model.OrderItem;
import com.resto.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
    
    @Autowired
    private OrderRepository OrderRepository;
    
    int countId = 1;
    
    public Optional<Order> getOrderById(String id) {
        return OrderRepository.findById(id);
    }

    public Order createOrder(Order Order) {
        
        try {
            
            Order.setOrderId(countId++);
            
            if (Order.getStatus() == null || Order.getStatus().isEmpty()) {
                Order.setStatus("pending");
            }

            for (OrderItem item : Order.getItem()) { // Iterasi array
                int total = 0;
                
                total = item.getQuantity() * item.getPrice(); // Hitung total
                
                item.setTotal(total);
                
            }

            return OrderRepository.save(Order);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
}
