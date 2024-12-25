package com.resto.backend.repository;

import com.resto.backend.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Menu, String> {
    
}
