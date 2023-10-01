package com.example.app.services;

 import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.EmpleadoModel;
import com.example.app.models.UserModel;
import com.example.app.repositories.EmpleadoRepositorie;
import com.example.app.repositories.UserRepositorie;

@Service
public class UserService {
    @Autowired
    UserRepositorie userRepositorie;
    @Autowired
    EmpleadoRepositorie empleadoRepositorie;


    public ArrayList<UserModel> getUsuarios(){
        return (ArrayList<UserModel>) userRepositorie.findAll();
    }

    public EmpleadoModel getEmpleado(Integer id){
        return empleadoRepositorie.findById(id).get();
    }
    


    public UserModel getUsuario(UserModel usuario){
        UserModel tmp = (UserModel)userRepositorie.findByNombre(usuario.getNombre());
        if(tmp != null){
            if(tmp.getContrasena().equals(usuario.getContrasena())){
                return tmp;
            }else return null;
        }else return null;

    }


    public UserModel guardarUsuario(UserModel usuario){
        return userRepositorie.save(usuario);
    }


}
