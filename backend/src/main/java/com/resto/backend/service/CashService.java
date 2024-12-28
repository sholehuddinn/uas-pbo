package com.resto.backend.service;

import com.resto.backend.model.Order;
import com.resto.backend.repository.CheckoutRepository;
import com.resto.backend.model.Chekout;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashService {

    @Autowired
    private CheckoutRepository co_repo;

    public Chekout createData (Chekout CO) {
        
        Chekout co = new Chekout(UUID.randomUUID().toString(),
                CO.getOrder_id(), 
                null,
                "cash",
                CO.getTransaction_status(),CO.getNama_kasir(), 
                CO.getGross_amount(),
                CO.getBayar(),
                LocalDateTime.now());
        
        return co_repo.save(co);
    }
    
}
