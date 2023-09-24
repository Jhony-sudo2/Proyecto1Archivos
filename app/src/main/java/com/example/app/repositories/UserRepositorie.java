package com.example.app.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.app.models.UserModel;

@Repository
public interface UserRepositorie extends CrudRepository<UserModel,Long> {
    UserModel findByNombre(String nombre);

}
