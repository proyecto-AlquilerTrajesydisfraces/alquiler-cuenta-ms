package com.TiendaDyT.backend_cuenta_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Prenda {

    @Id
    private String id;
    //conexion con cuenta
    private String username;
    private String tipoPrenda;
    private String prenda;
    private Integer cantidad;
    private String talla;
    private Date fechaInicioPedido;
    private Date fechaEntrega;
    private String detalles;
    private Boolean estado;

    public Prenda(String id, String username, String tipoPrenda, String prenda,Integer cantidad,String talla,Date fechaInicioPedido,Date fechaEntrega, String detalles, Boolean estado){
        //constructor
        this.id = id;
        this.username= username;
        this.tipoPrenda = tipoPrenda;
        this.prenda = prenda;
        this.cantidad = cantidad;
        this.talla = talla;
        this.fechaInicioPedido = fechaInicioPedido;
        this.fechaEntrega = fechaEntrega;
        this.detalles = detalles;
        this.estado = estado;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public String getPrenda() {
        return prenda;
    }

    public void setPrenda(String prenda) {
        this.prenda = prenda;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Date getFechaInicioPedido() {
        return fechaInicioPedido;
    }

    public void setFechaInicioPedido(Date fechaInicioPedido) {
        this.fechaInicioPedido = fechaInicioPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
