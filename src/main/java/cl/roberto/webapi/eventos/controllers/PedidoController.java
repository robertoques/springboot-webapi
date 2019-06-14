package cl.roberto.webapi.eventos.controllers;

import cl.roberto.webapi.eventos.entities.Pedido;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PedidoController {

    static{

    }

    @GetMapping("/pedidos")
    public List<Pedido> findAll(){
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(1, 10, "rueda", new Date()));
        pedidos.add(new Pedido(2, 20, "llanta", new Date()));
        pedidos.add(new Pedido(3, 30, "freno", new Date()));

        return pedidos;
    }
}
