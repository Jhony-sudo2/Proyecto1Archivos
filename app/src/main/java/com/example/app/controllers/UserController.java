package com.example.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.UserModel;
import com.example.app.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return userService.getUsuarios();
    }

    @PostMapping
    public UserModel getUser(@RequestBody UserModel usuario){
        UserModel tmp = this.userService.getUsuario(usuario);
        if(tmp!=null & tmp.getContrasena().equals(usuario.getContrasena())) return tmp;
        else return null;
    }
   

}
