package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventario")
public class InventarioModel {
    @Id
    private String Sucursal;
    private String Producto;
    private int Existencia;
    
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
    public int getExistencia() {
        return Existencia;
    }
    public void setExistencia(int existencia) {
        Existencia = existencia;
    }

    

}
