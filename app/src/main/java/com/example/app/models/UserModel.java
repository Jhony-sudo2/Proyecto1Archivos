package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario",schema = "rtienda")
public class UserModel {
    private String nombre;
    private String contrasena;
    private int tipo;
    @Id
    private Long empleado;
    private int caja;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public Long getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Long empleado) {
        this.empleado = empleado;
    }
    public int getCaja() {
        return caja;
    }
    public void setCaja(int caja) {
        this.caja = caja;
    } 


    
    

}
