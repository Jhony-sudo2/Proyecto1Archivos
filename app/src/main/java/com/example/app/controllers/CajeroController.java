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

import com.example.app.models.ClienteModel;
import com.example.app.models.DescripcionModel;
import com.example.app.models.ProductoModel;
import com.example.app.models.VentaModel;
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
    public HttpStatus saveCliente(@RequestBody ClienteModel clienteModel){
        return cajeroService.IngresarCliente(clienteModel);
    }

    @PostMapping("/Producto")
    public ArrayList<ProductoModel> getProductos(@RequestBody String Sucursal){
        return cajeroService.getProductos(Sucursal);
    }

    @PostMapping("/VentaDescripcion")
    public void saveDescripcion(@RequestBody DescripcionModel descripcionModel){
        System.out.println(descripcionModel.getFactura());
        cajeroService.GuardarDescripcion(descripcionModel);
    }

    @GetMapping("/VentaDescripcion")
    public ArrayList<DescripcionModel> getDescripciones(){
        return cajeroService.getDescripciones();
    }


    @PostMapping("/Venta")
    public void saveVenta(@RequestBody VentaModel ventaModel){
        cajeroService.GuardarVenta(ventaModel);
    }



}
