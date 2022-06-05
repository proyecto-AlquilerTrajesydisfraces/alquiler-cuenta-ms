package com.TiendaDyT.backend_cuenta_ms.repositories;
import com.TiendaDyT.backend_cuenta_ms.models.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CuentaRepository extends MongoRepository<Cuenta,String>{}
