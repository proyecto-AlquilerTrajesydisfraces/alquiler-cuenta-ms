package com.TiendaDyT.backend_cuenta_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class PrendasInsuficientesAdvice {
    @ResponseBody
    @ExceptionHandler(PrendasInsufucientesException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String PrendasInsuficientesAdvice(PrendasInsufucientesException ex){
        return ex.getMessage();
    }
}

