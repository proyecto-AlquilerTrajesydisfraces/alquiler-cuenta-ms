package com.TiendaDyT.backend_cuenta_ms.controllers;

import com.TiendaDyT.backend_cuenta_ms.exceptions.PedidoNoEncontradoException;
import com.TiendaDyT.backend_cuenta_ms.models.Prenda;
import com.TiendaDyT.backend_cuenta_ms.repositories.PrendaRepository;
import com.TiendaDyT.backend_cuenta_ms.exceptions.PrendasInsufucientesException;

import com.TiendaDyT.backend_cuenta_ms.models.Cuenta;
import com.TiendaDyT.backend_cuenta_ms.repositories.CuentaRepository;
import com.TiendaDyT.backend_cuenta_ms.exceptions.CuentaNoEncontradaException;

import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class PrendaController {

    private final PrendaRepository prendaRepository;
    private final CuentaRepository cuentaRepository;

    public PrendaController(CuentaRepository cuentaRepository, PrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
        this.cuentaRepository= cuentaRepository;
    }

    @PostMapping("/prendas")
    Prenda newPrenda(@RequestBody Prenda prendaCrear){
        Cuenta cuenta = cuentaRepository.findById(prendaCrear.getUsername()).orElse(null);

        if (cuenta == null){
            throw new CuentaNoEncontradaException("No se encontro una cuenta asociada al usuario:  " + prendaCrear.getUsername());
        }

        if (prendaCrear.getCantidad() >= 40){
            throw new PrendasInsufucientesException("la cantidad de prendas solicitadas es mayor al stock");
        }

        if (prendaCrear.getCantidad() <= 0){
            throw new PrendasInsufucientesException("la cantidad de prendas solicitadas no es valida");
        }

        //incremento de cantidad de prendas al momento de solicitarlas
        cuenta.setPrendasAlquiladas(cuenta.getPrendasAlquiladas()+ prendaCrear.getCantidad());
        //actualizacion de la fecha cuando aumentan las prendas
        cuenta.setFechaUltimoAlquiler(new Date());
        //en el repositorio se guarda el objeto
        cuentaRepository.save(cuenta);

        prendaCrear.setFechaInicioPedido(new Date());
        prendaCrear.setTipoPrenda(prendaCrear.getTipoPrenda());
        prendaCrear.setPrenda(prendaCrear.getPrenda());
        prendaCrear.setDetalles(prendaCrear.getDetalles());
        prendaCrear.setCantidad(prendaCrear.getCantidad());
        prendaCrear.setTalla(prendaCrear.getTalla());


        //Obtiene una instancia de un calendario
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Configuramos la fecha que se recibe que en este caso es la actual
        //adicionamos los 15 dias a partir de la fecha actual
        calendar.add(Calendar.DAY_OF_YEAR, 15);

        prendaCrear.setFechaEntrega(calendar.getTime());

        //Obtiene una instancia de un calendario
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(prendaCrear.getFechaEntrega()); // Configuramos la fecha que se recibe que en este caso es la actual
        //adicionamos los 15 dias a partir de la fecha actual
        calendar2.add(Calendar.DAY_OF_YEAR, 16);

        if (prendaCrear.getFechaEntrega() == calendar2.getTime()){
            prendaCrear.setEstado(false);
        }else{
            prendaCrear.setEstado(true);
        }

        return prendaRepository.save(prendaCrear);

    }

    //todos los pedidos de prendas por username
    @GetMapping("/pedidosPrendas/{username}")
    List<Prenda> prendaUsuario (@PathVariable String username) {
        Cuenta cuentaUsuario = this.cuentaRepository.findById(username).orElse(null);
        if (cuentaUsuario == null) {
            throw new CuentaNoEncontradaException("La cuenta con usuario " + username
                    + " no se encuentra registrada en la base de datos.");
        }

        List<Prenda> prendas =  prendaRepository.findByUsername(username);
        return prendas;
    }

    @PutMapping("/pedidosPrendas/actualizar/{id}")
    Prenda updatePrendas(@PathVariable String id, @RequestBody Prenda prendaUpdate){
        Prenda prenda = this.prendaRepository.findById(id).orElse(null);
        if(prenda == null){
            throw new PedidoNoEncontradoException("El numero del pedido no existe en la base de datos.");
        }
        //Obtiene una instancia de un calendario
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Configuramos la fecha que se recibe que en este caso es la actual
        //adicionamos los 15 dias a partir de la fecha actual
        calendar.add(Calendar.DAY_OF_YEAR, 15);

        prenda.setTipoPrenda( prendaUpdate.getTipoPrenda());
        prenda.setPrenda( prendaUpdate.getPrenda());
        prenda.setCantidad( prendaUpdate.getCantidad());
        prenda.setTalla( prendaUpdate.getTalla());
        prenda.setFechaEntrega(calendar.getTime());
        prenda.setEstado(prendaUpdate.getEstado());

        return prendaRepository.save(prenda);
    }

    @DeleteMapping("/pedidos/eliminar/{id}")
    String deleteTransaction(@PathVariable String id){
        Prenda prenda = this.prendaRepository.findById(id).orElse(null);
        if(prenda == null){
            throw new PedidoNoEncontradoException("El numero de pedido no existe en la base de datos.");
        }
        this.prendaRepository.deleteById(id);
        return "Eliminación exitosa!!";
    }
}
