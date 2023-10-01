package com.example.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.EstanteModel;
import com.example.app.models.ProductoModel;
import com.example.app.services.InventarioService;

@RestController
@RequestMapping("/invetario")
@CrossOrigin(origins = "http://localhost:4200")
public class InventarioController {

    @Autowired
    InventarioService servicio;

    @PostMapping
    public HttpStatus GuardarProducto(@RequestBody EstanteModel model){
       return servicio.GuardarenEstanteria(model);
    }


    @PostMapping("/info")
    public ProductoModel getProducto(@RequestBody ProductoModel productoModel){
        return servicio.getProducto(productoModel.getId(),productoModel.getSucursal());
    }


    
}
