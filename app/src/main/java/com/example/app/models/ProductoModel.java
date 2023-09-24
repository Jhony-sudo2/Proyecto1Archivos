package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Producto",schema = "manejoproducto")
public class ProductoModel {

    @Id
    private String id;
    private String nombre;
    private String marca;
    private String sucursal;
    private double precio;
    private String pasillo;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getSucursal() {
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getPasillo() {
        return pasillo;
    }
    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }
      
    
    

}

