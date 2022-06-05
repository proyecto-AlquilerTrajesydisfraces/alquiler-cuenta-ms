package com.TiendaDyT.backend_cuenta_ms.repositories;
import com.TiendaDyT.backend_cuenta_ms.models.Prenda;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//el tipo de dato que se define en el operador diamante va de acuerdo al tipo de dato del id que conecta las entidades
public interface PrendaRepository extends MongoRepository<Prenda,String>{
    List<Prenda> findByUsername(String username);
}
