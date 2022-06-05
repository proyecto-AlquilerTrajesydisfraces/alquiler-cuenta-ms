package com.TiendaDyT.backend_cuenta_ms.controllers;

import com.TiendaDyT.backend_cuenta_ms.models.Cuenta;
import com.TiendaDyT.backend_cuenta_ms.repositories.CuentaRepository;
import com.TiendaDyT.backend_cuenta_ms.exceptions.CuentaNoEncontradaException;
import org.springframework.web.bind.annotation.*;


@RestController
public class CuentaController {
    private final CuentaRepository cuentaRepository;

    public CuentaController(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }

    @GetMapping("/")
    String startMessage(){
        return "Bienvenido al microservicio de cuenta";
    }

    //detalle cuenta
    @GetMapping("/cuentas/{username}")
    Cuenta getCuenta(@PathVariable String username){
        return cuentaRepository.findById(username)
                .orElseThrow(()-> new CuentaNoEncontradaException("No se encontro una cuenta al usuario" +
                        username + " solicitado")
                );
    }

    //crear cuenta
     @PostMapping("/cuentas")
     Cuenta newCuenta(@RequestBody Cuenta cuenta){
        return cuentaRepository.save(cuenta);
     }
}
