package com.example.app.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.models.ClienteModel;
import com.example.app.models.EmpleadoModel;
import com.example.app.models.TarjetaModel;
import com.example.app.models.UserModel;
import com.example.app.repositories.ClienteRepositorie;
import com.example.app.repositories.EmpleadoRepositorie;
import com.example.app.repositories.TarjetaRepositorie;
import com.example.app.repositories.UserRepositorie;

@Service
public class AdminService {
    @Autowired
    EmpleadoRepositorie empleadoRepositorie;
    @Autowired
    ClienteRepositorie clienteRepositorie;

    @Autowired
    UserRepositorie userRepositorie;

    @Autowired
    TarjetaRepositorie tarjetaRepositorie;

    @PersistenceContext
    public EntityManager entityManager;

    public HttpStatus GuardarEmpleado(EmpleadoModel empleadoModel){
        EmpleadoModel tmp = empleadoRepositorie.findByCui(empleadoModel.getCui());
        if(tmp == null) {
            empleadoRepositorie.save(empleadoModel);
            return HttpStatus.OK;
        }
        else{
            return HttpStatus.BAD_GATEWAY;
        }
    }

    public ArrayList<EmpleadoModel> getEmpleados(){
        return (ArrayList<EmpleadoModel>) empleadoRepositorie.findAll();
    }

    public ArrayList<String> getClientes(){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<ClienteModel> tmp = (ArrayList<ClienteModel>)clienteRepositorie.findAll();

        for (ClienteModel tClienteModel : tmp) {
            result.add(tClienteModel.getNit());
        }
        return result;
    }

    @Transactional
    public ArrayList<EmpleadoModel> getEmpleadossinUsuario(){
        return (ArrayList<EmpleadoModel>) entityManager.createQuery("SELECT e FROM EmpleadoModel e LEFT JOIN UserModel u ON e.id = u.empleado WHERE u.empleado IS NULL"
        ,EmpleadoModel.class).getResultList();
    }

    public HttpStatus GuardarUsuario(UserModel userModel){
        System.out.println("Guardando usuario: " + userModel.getNombre());
        UserModel tmp = userRepositorie.findByNombre(userModel.getNombre());
        if(tmp == null){
            userRepositorie.save(userModel);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_GATEWAY;
    }

    public void guardarTarjeta(TarjetaModel tarjetaModel){
        tarjetaRepositorie.save(tarjetaModel);
    }

    @Transactional
    public ArrayList<Object[]> Reporte1(){
        String sql = "SELECT p.Sucursal, p.Nombre AS NombreProducto, d.Producto, SUM(d.Cantidad) AS TotalProductosVendidos " +
             "FROM ventas.Descripcion AS d " +
             "JOIN manejoproducto.Producto AS p ON d.Producto = p.Id " +
             "GROUP BY p.Sucursal, p.Nombre, d.Producto " +
             "ORDER BY TotalProductosVendidos DESC";

        ArrayList<Object[]> resultado = (ArrayList<Object[]>)entityManager.createNativeQuery(sql)
        .getResultList();
        return resultado;
    }
    public void Reporte2(){
        
    }
    public void Reporte3(){
        
    }
    public void Reporte4(){
        
    }
    public void Reporte5(){
        
    }
    public void Reporte6(){
        
    }

}
