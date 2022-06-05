package com.TiendaDyT.backend_cuenta_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Cuenta {
    @Id
    private String username;
    private Integer prendasAlquiladas;
    private Date fechaUltimoAlquiler;

    //creamos un objeto con los tres atributos

    public Cuenta(String username, Integer prendasAlquiladas, Date fechaUltimoAlquiler){
    //this esta asociado al atributo de la parte de arriba, no el que le estamos pasando por parametro
    //constructor
        this.username = username;
        this.prendasAlquiladas = prendasAlquiladas;
        this.fechaUltimoAlquiler= fechaUltimoAlquiler;
   }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPrendasAlquiladas() {
        return prendasAlquiladas;
    }

    public void setPrendasAlquiladas(Integer prendasAlquiladas) {
        this.prendasAlquiladas = prendasAlquiladas;
    }

    public Date getFechaUltimoAlquiler() {
        return fechaUltimoAlquiler;
    }

    public void setFechaUltimoAlquiler(Date fechaUltimoAlquiler) {
        this.fechaUltimoAlquiler = fechaUltimoAlquiler;
    }
}
