package com.example.app.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.app.models.EmpleadoModel;

public interface EmpleadoRepositorie extends CrudRepository<EmpleadoModel,Integer>{
    EmpleadoModel findByCui(String CUI);
}
