package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")
public class UsuarioModel {
    private String Nombre;
    private String Apellido;
    private String FechaNacimiento;
    @Id
    private String CUI;
    private int Salario;
    private String Sucursarl;
    private String Telefono;
    private String Direccion;

    public UsuarioModel(String nombre, String apellido, String fechaNacimiento, String cUI, 
                        int salario, String sucursarl,String telefono, String direccion) {
        Nombre = nombre;
        Apellido = apellido;
        FechaNacimiento = fechaNacimiento;
        CUI = cUI;
        Salario = salario;
        Sucursarl = sucursarl;
        Telefono = telefono;
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String cUI) {
        CUI = cUI;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    public String getSucursarl() {
        return Sucursarl;
    }

    public void setSucursarl(String sucursarl) {
        Sucursarl = sucursarl;
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

    

}
