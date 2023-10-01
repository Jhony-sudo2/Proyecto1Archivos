package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estantes",schema = "manejoproducto")
public class EstanteModel {
    
    private String sucursal;
    @Id
    private String producto;
    private int cantida;
    public String getSucursal() {
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public int getCantida() {
        return cantida;
    }
    public void setCantida(int cantida) {
        this.cantida = cantida;
    }
    

    

}
