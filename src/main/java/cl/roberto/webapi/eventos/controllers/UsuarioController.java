package cl.roberto.webapi.eventos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @GetMapping(path = "/usuario")
    public String saludo(){
        return "Hola Mundo!";
    }

    @GetMapping(path = "/usuario/{id}")
    public String saludo(@PathVariable int id){
        return "Hola Mundo! " + id;
    }

    
}
