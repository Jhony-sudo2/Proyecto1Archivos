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
import com.example.app.models.EmpleadoModel;
import com.example.app.models.TarjetaModel;
import com.example.app.models.UserModel;
import com.example.app.services.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping
    public HttpStatus GuardarEmpleado(@RequestBody EmpleadoModel empleadoModel){
        return adminService.GuardarEmpleado(empleadoModel);
    }

    @GetMapping
    public ArrayList<EmpleadoModel> getUsuarios(){
        return adminService.getEmpleados();
    }

    @GetMapping("/tarjeta")
    public ArrayList<String> getClientes(){
        return adminService.getClientes();
    }

    @PostMapping("/tarjeta")
    public void guardarTarjeta(@RequestBody TarjetaModel tarjetaModel){
        adminService.guardarTarjeta(tarjetaModel);
    }

    @GetMapping("/usuarios")
    public ArrayList<EmpleadoModel> getEmpleadossinUsuaiors(){
        return adminService.getEmpleadossinUsuario();
    }

    @PostMapping("/usuarios")
    public HttpStatus GuardarUsuario(@RequestBody UserModel user){
        return adminService.GuardarUsuario(user);
    }

    @GetMapping("/reporte1")
    public ArrayList<Object[]> getReporte1(){
        return adminService.Reporte1();
    }

    
}
