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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrderService {
    
    @Autowired
    private OrderRepository OrderRepository;
    
    public Optional<Order> getOrderById(String id) {
        return OrderRepository.findById(id);
    }

    public Order createOrder(Order Order) {
        
        try {
            
            if (Order.getStatus() == null || Order.getStatus().isEmpty()) {
                Order.setStatus("pending");
            }
            
            int grand = 0;

            for (OrderItem item : Order.getItem()) { 
                int total = 0;
                
                total = item.getQuantity() * item.getPrice(); 
                
                item.setTotal(total);
                
                grand += total;
            }
            
            Order.setGross_amount(grand);

            return OrderRepository.save(Order);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public Order updateOrderStatus(String orderId, String status) {
        
        Optional<Order> orderOptional = OrderRepository.findById(orderId);
        if (orderOptional.isPresent()) {

            Order order = orderOptional.get();

            order.setStatus(status);

            return OrderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
    }
    
    public Order[] getOrderByStatus(String Status) {
        List<Order> orders = OrderRepository.findByStatus(Status);
        return orders.toArray(new Order[0]); 
    }
}
