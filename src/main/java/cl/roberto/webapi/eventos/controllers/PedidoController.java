package cl.roberto.webapi.eventos.controllers;

import cl.roberto.webapi.eventos.entities.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class PedidoController {

    static{

    }

    @GetMapping("/pedidos")
    public List<Pedido> obtenerTodos(){
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(1, 10, "rueda", new Date()));
        pedidos.add(new Pedido(2, 20, "llanta", new Date()));
        pedidos.add(new Pedido(3, 30, "freno", new Date()));

        return pedidos;
    }

    @GetMapping("/pedidos/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable int id){
        return new Pedido(10, 2, "piola", new Date());
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Object> nuevoPedido(@Valid @RequestBody Pedido pedido){
      log.info("Nuevo pedido");
      if(pedido!=null){
          log.info(pedido.toString());
      }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
