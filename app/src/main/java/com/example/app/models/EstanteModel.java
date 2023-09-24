package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estante")
public class EstanteModel {
    @Id
    private String Sucursal;
    private String Producto;
    private int Cantidad;

    public String getSucursal() {
        return Sucursal;
    }
    public void setSucursal(String sucursal) {
        Sucursal = sucursal;
    }
    public String getProducto() {
        return Producto;
    }
    public void setProducto(String producto) {
        Producto = producto;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    

}
