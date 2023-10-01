package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.app.models.InventarioModel;

public interface InventarioRepositorie extends CrudRepository<InventarioModel,String>{

}