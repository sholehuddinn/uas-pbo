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

            for (OrderItem item : Order.getItem()) { // Iterasi array
                int total = 0;
                
                total = item.getQuantity() * item.getPrice(); // Hitung total
                
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
    // Mencari order berdasarkan ID
    Optional<Order> orderOptional = OrderRepository.findById(orderId);
    if (orderOptional.isPresent()) {
        
        // Ambil data order
        Order order = orderOptional.get();
        
        // Set status baru
        order.setStatus(status);
        
        // Simpan perubahan ke database
        return OrderRepository.save(order);
    } else {
        // Lempar exception jika order tidak ditemukan
        throw new RuntimeException("Order not found with ID: " + orderId);
    }
    }
    
    public Order[] getOrderByStatus(String Status) {
        List<Order> orders = OrderRepository.findByStatus(Status);
        return orders.toArray(new Order[0]); 
    }
}
