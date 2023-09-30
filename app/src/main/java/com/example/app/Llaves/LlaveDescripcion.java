package com.example.app.Llaves;
import java.io.Serializable;
import java.util.Objects;
public class LlaveDescripcion implements Serializable{
    
    private Integer id;
    private String factura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LlaveDescripcion that = (LlaveDescripcion) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(factura, that.factura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, factura);
    }    
}
