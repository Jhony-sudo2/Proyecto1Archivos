package com.example.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.app.models.EstanteModel;
import com.example.app.models.InventarioModel;
import com.example.app.models.ProductoModel;
import com.example.app.repositories.EstanteRepositorie;
import com.example.app.repositories.InventarioRepositorie;
import com.example.app.repositories.ProductoRepositorie;

@Service
public class InventarioService {
    @Autowired
    ProductoRepositorie productoRepositorie;

    @Autowired
    EstanteRepositorie estanteRepositorie;

    @Autowired
    InventarioRepositorie inventarioRepositorie;

    
    
    public ProductoModel getProducto(String codigo,String Sucursal){
        Optional<ProductoModel> tmp = productoRepositorie.findById(codigo);
        if(tmp.isPresent()){
            if(tmp.get().getSucursal().equals(Sucursal))
            return productoRepositorie.findById(codigo).get();

        }
        return null; 
    }


    public HttpStatus GuardarenEstanteria(EstanteModel estanteModel){
        Optional<InventarioModel> tmp2 = inventarioRepositorie.findById(estanteModel.getProducto());

        if(tmp2.isPresent()){    
            if(estanteModel.getSucursal().equals(tmp2.get().getSucursal()) && (tmp2.get().getExistencia() - estanteModel.getCantida() >=0)){
                int nuevo = tmp2.get().getExistencia() - estanteModel.getCantida();
                Optional<EstanteModel> tmp = estanteRepositorie.findById(estanteModel.getProducto());

                if(tmp.isPresent()){
                    estanteModel.setCantida(tmp.get().getCantida() + estanteModel.getCantida());
                }
                tmp2.get().setExistencia(nuevo);
                inventarioRepositorie.save(tmp2.get());
                estanteRepositorie.save(estanteModel);
                return HttpStatus.OK;
            }else return HttpStatus.CONFLICT;
        }else return HttpStatus.BAD_GATEWAY;


    }
    
}
