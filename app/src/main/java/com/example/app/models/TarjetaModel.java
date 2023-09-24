package com.example.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tarjeta")
public class TarjetaModel {
    @Id
    private String Id;
    private String Cliente;
    private int Tipo;
    private int Puntos;
    
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getCliente() {
        return Cliente;
    }
    public void setCliente(String cliente) {
        Cliente = cliente;
    }
    public int getTipo() {
        return Tipo;
    }
    public void setTipo(int tipo) {
        Tipo = tipo;
    }
    public int getPuntos() {
        return Puntos;
    }
    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    


}
