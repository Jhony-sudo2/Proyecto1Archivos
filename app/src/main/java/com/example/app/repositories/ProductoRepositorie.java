package com.example.app.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.ProductoModel;

@Repository
public interface ProductoRepositorie extends CrudRepository<ProductoModel,String> {
    ArrayList<ProductoModel> findBySucursal(String Sucursal);
}
