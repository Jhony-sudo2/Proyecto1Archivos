package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.ProductoModel;

@Repository
public interface ProductoRepositorie extends CrudRepository<ProductoModel,String> {
    
}
