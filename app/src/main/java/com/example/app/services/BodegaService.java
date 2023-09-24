package com.example.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.ProductoModel;
import com.example.app.repositories.ProductoRepositorie;

@Service
public class BodegaService {
    @Autowired
    ProductoRepositorie productoRepositorie;


    public boolean saveProducto(ProductoModel productoModel){
        if(productoRepositorie.findById(productoModel.getId()) == null){
            productoRepositorie.save(productoModel);
            return true;
        }else return false;
    }


    public ArrayList<ProductoModel> getProducto(){
        return (ArrayList<ProductoModel>) productoRepositorie.findAll();
    }




}
