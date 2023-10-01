package com.example.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.app.models.TarjetaModel;

public interface TarjetaRepositorie extends CrudRepository<TarjetaModel,Integer>{
    TarjetaModel findByCliente(String nit);
}
