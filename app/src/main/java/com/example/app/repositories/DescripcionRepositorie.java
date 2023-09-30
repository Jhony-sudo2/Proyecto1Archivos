package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.app.Llaves.LlaveDescripcion;
import com.example.app.models.DescripcionModel;

public interface DescripcionRepositorie extends CrudRepository<DescripcionModel,LlaveDescripcion>{
    
}
