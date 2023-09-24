package com.example.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.ClienteModel;
import com.example.app.services.CajeroService;

@RestController
@RequestMapping("/Cajero")
@CrossOrigin(origins = "http://localhost:4200")
public class CajeroController {
    @Autowired
    CajeroService cajeroService;



    @PostMapping("/Precio")
    public double getPrecio(@RequestBody String Codigo){
        System.out.println("RECIBIENDO: " + Codigo);
        return cajeroService.getPrecio(Codigo).getPrecio();
    }


    @PostMapping
    public void saveCliente(@RequestBody ClienteModel clienteModel){
        cajeroService.IngresarCliente(clienteModel);
    }
    



}
