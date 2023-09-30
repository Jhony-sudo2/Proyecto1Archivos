package com.example.app.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.models.ClienteModel;
import com.example.app.models.DescripcionModel;
import com.example.app.models.ProductoModel;
import com.example.app.models.VentaModel;
import com.example.app.repositories.ClienteRepositorie;
import com.example.app.repositories.DescripcionRepositorie;
import com.example.app.repositories.ProductoRepositorie;
import com.example.app.repositories.VentaRepositorie;

@Service
public class CajeroService {
    @Autowired
    ProductoRepositorie productoRepositorie;
    @Autowired
    ClienteRepositorie  clienteRepositorie;
    @Autowired
    VentaRepositorie ventaRepositorie;
    @Autowired
    DescripcionRepositorie descripcionRepositorie;

    @PersistenceContext
    public EntityManager entityManager;


    public ProductoModel getPrecio(String Codigo){
        return productoRepositorie.findById(Codigo).get();
    }

    public HttpStatus IngresarCliente(ClienteModel clienteModel){
        ClienteModel tmp = (ClienteModel)clienteRepositorie.findByNit(clienteModel.getNit());
        if(tmp ==null){
            clienteRepositorie.save(clienteModel);
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_GATEWAY;
        }
    }

    public ArrayList<ProductoModel> getProductos(String Sucursal){
        return productoRepositorie.findBySucursal(Sucursal);
    }

    @Transactional
    public void GuardarDescripcion(DescripcionModel descripcionModel){
        String jpql = "INSERT INTO ventas.descripcion(factura,producto,cantidad,total) VALUES(:valor1,:valor2,:valor3,:valor4)";
        entityManager.createNativeQuery(jpql)
            .setParameter("valor1", descripcionModel.getFactura())
            .setParameter("valor2", descripcionModel.getProducto())
            .setParameter("valor3", descripcionModel.getCantidad())
            .setParameter("valor4", descripcionModel.getTotal())
            .executeUpdate();
    }
    

    public void GuardarVenta(VentaModel ventaModel){
        ventaRepositorie.save(ventaModel);
    }

    public ArrayList<DescripcionModel> getDescripciones(){
        return (ArrayList<DescripcionModel>) descripcionRepositorie.findAll();
    }

}
