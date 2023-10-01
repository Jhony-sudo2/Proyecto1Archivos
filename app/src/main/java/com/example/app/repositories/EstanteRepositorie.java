package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.app.models.EstanteModel;

public interface EstanteRepositorie extends CrudRepository<EstanteModel,String>{
    
}
