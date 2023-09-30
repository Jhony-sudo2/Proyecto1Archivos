package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.app.models.VentaModel;

public interface VentaRepositorie extends CrudRepository<VentaModel,String>{
    
}
