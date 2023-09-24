package com.example.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.ClienteModel;
import com.example.app.models.ProductoModel;
import com.example.app.repositories.ClienteRepositorie;
import com.example.app.repositories.ProductoRepositorie;

@Service
public class CajeroService {
    @Autowired
    ProductoRepositorie productoRepositorie;
    ClienteRepositorie  clienteRepositorie;


    public ProductoModel getPrecio(String Codigo){
        System.out.println("BUSCANDO CON: " + Codigo);
        return productoRepositorie.findById(Codigo).get();
    }

    public void IngresarCliente(ClienteModel clienteModel){
        clienteRepositorie.save(clienteModel);
    }

}
