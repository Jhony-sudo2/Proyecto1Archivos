package com.example.app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.app.models.InventarioModel;
import com.example.app.models.ProductoModel;
import com.example.app.repositories.InventarioRepositorie;
import com.example.app.repositories.ProductoRepositorie;

@Service
public class BodegaService {
    @Autowired
    ProductoRepositorie productoRepositorie;

    @Autowired
    InventarioRepositorie inventarioRepositorie;


    public boolean saveProducto(ProductoModel productoModel){
        if(!productoRepositorie.findById(productoModel.getId()).isPresent()){
            productoRepositorie.save(productoModel);
            return true;
        }else return false;
    }


    public ArrayList<ProductoModel> getProducto(){
        return (ArrayList<ProductoModel>) productoRepositorie.findAll();
    }

    public HttpStatus IngresoProducto(InventarioModel inventarioModel){
        System.out.println("INGRESANDO: "+ inventarioModel.getProducto());
        Optional<ProductoModel> tmOptional = productoRepositorie.findById(inventarioModel.getProducto());

        if(tmOptional.isPresent()){
            ProductoModel tmp2 = tmOptional.get();
            if(tmp2 != null && tmp2.getSucursal().equals(inventarioModel.getSucursal())){
                System.out.println(inventarioModel.getExistencia());
                Optional<InventarioModel> tmp = inventarioRepositorie.findById(inventarioModel.getProducto());
                if(tmp.isPresent())
                    inventarioModel.setExistencia(tmp.get().getExistencia() + inventarioModel.getExistencia());
                inventarioRepositorie.save(inventarioModel);
                return HttpStatus.OK;
            }else return HttpStatus.BAD_GATEWAY;
        }else return HttpStatus.BAD_GATEWAY;
    }




}
