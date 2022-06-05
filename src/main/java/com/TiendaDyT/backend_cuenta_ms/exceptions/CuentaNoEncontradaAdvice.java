package com.TiendaDyT.backend_cuenta_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//controlador de sugerencias, con el decorador se da propiedades adicionales a la clase para ser controlador y  para que se genere una respuesta en un servicio web
@ControllerAdvice
@ResponseBody
public class CuentaNoEncontradaAdvice {
    //metodo que va a generar la respuesta
    @ResponseBody
    @ExceptionHandler(CuentaNoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(CuentaNoEncontradaException ex){
        return ex.getMessage();
    }
}
