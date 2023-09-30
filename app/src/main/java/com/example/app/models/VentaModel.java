package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venta",schema = "ventas")
public class VentaModel {
    @Id
    private String factura;
    private String cliente;
    private int empleado;
    private int total;
    private int totaldescuento;
    private String sucursal;
    public String getFactura() {
        return factura;
    }
    public void setFactura(String factura) {
        this.factura = factura;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public int getEmpleado() {
        return empleado;
    }
    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotaldescuento() {
        return totaldescuento;
    }
    public void setTotaldescuento(int totaldescuento) {
        this.totaldescuento = totaldescuento;
    }
    public String getSucursal() {
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    



    
}
