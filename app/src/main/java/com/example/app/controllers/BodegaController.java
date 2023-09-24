package com.example.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.ProductoModel;
import com.example.app.services.BodegaService;

@RestController
@RequestMapping("/bodega")
@CrossOrigin(origins = "http://localhost:4200")
public class BodegaController {
    @Autowired
    BodegaService bodegaService;


    @PostMapping
    public HttpStatus saveProducto(@RequestBody ProductoModel productoModel){
        System.out.println("Guardando producto: " + productoModel.getNombre());
        if(bodegaService.saveProducto(productoModel))
        return HttpStatus.OK;
        else return HttpStatus.CONFLICT;
    }


    @GetMapping
    public ArrayList<ProductoModel> getProductos(){
        return bodegaService.getProducto();
    }
}
