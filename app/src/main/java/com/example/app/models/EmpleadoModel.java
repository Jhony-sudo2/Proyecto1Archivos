package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")
public class EmpleadoModel {

    @Id
    private int Id;
    private String CUI;
    private String Nombre;
    private String Apellidos;
    private String Nacimiento;
    private String Telefono;
    private String Direccion;
    private double Sueldo;
    private String Sucursal;

    public String getCUI() {
        return CUI;
    }
    public void setCUI(String cUI) {
        CUI = cUI;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public String getNacimiento() {
        return Nacimiento;
    }
    public void setNacimiento(String nacimiento) {
        Nacimiento = nacimiento;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public double getSueldo() {
        return Sueldo;
    }
    public void setSueldo(double sueldo) {
        Sueldo = sueldo;
    }
    public String getSucursal() {
        return Sucursal;
    }
    public void setSucursal(String sucursal) {
        Sucursal = sucursal;
    }

    

}
