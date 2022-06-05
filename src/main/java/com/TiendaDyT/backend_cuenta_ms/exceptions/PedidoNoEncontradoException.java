package com.TiendaDyT.backend_cuenta_ms.exceptions;

//estas excepciones van a ser visibles cuando se este ejecutando el codigo mas no cuando se este compilando
public class PedidoNoEncontradoException extends RuntimeException {
    public PedidoNoEncontradoException(String message){
        super(message);
    }
}
