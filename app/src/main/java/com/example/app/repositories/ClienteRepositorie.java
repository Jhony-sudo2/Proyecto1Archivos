package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.app.models.ClienteModel;

public interface ClienteRepositorie extends CrudRepository<ClienteModel,String> {
    
}
