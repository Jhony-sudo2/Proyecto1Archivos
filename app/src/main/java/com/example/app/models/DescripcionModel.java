package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Descripcion")
public class DescripcionModel {

    @Id
    private String Factura;
    private String Producto;
    private int Cantidad;
    private int Total;
    private String Sucursal;
    public String getFactura() {
        return Factura;
    }
    public void setFactura(String factura) {
        Factura = factura;
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
    public int getTotal() {
        return Total;
    }
    public void setTotal(int total) {
        Total = total;
    }
    public String getSucursal() {
        return Sucursal;
    }
    public void setSucursal(String sucursal) {
        Sucursal = sucursal;
    }

    

}
