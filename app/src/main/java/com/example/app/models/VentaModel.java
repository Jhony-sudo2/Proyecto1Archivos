package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Venta")
public class VentaModel {
    @Id
    private String Factura;
    private String Cliente;
    private String Empleado;
    private int Total;
    private int TotalDescuento;
    private String Descripcion;
    public String getFactura() {
        return Factura;
    }
    public void setFactura(String factura) {
        Factura = factura;
    }
    public String getCliente() {
        return Cliente;
    }
    public void setCliente(String cliente) {
        Cliente = cliente;
    }
    public String getEmpleado() {
        return Empleado;
    }
    public void setEmpleado(String empleado) {
        Empleado = empleado;
    }
    public int getTotal() {
        return Total;
    }
    public void setTotal(int total) {
        Total = total;
    }
    public int getTotalDescuento() {
        return TotalDescuento;
    }
    public void setTotalDescuento(int totalDescuento) {
        TotalDescuento = totalDescuento;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    
}
