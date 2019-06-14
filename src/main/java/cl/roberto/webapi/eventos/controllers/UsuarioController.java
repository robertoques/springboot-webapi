package cl.roberto.webapi.eventos.controllers;

import cl.roberto.webapi.eventos.entities.Usuario;
import cl.roberto.webapi.eventos.exception.UsuarioNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class UsuarioController {

    @Autowired
    private MessageSource messageResource;


    @GetMapping(path = "/usuario")
    public String saludo() {
        return "Hola Mundo!";
    }

    @GetMapping(path = "/usuario/{id}")
    public String saludo(@PathVariable int id) {

        if (id < 1) {
            throw new UsuarioNotFoundException("id: " + id);
        }

        return "Hola Mundo! " + id;
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable int id) {

        if (id < 1) {
            throw new UsuarioNotFoundException("id: " + id);
        }

        log.info("Usuario eliminadd");
    }

    @GetMapping("/usuarios/{id}")
    public Resource<Usuario> obtenerUsuarioPorId(@PathVariable int id) {

        if (id < 1) {
            throw new UsuarioNotFoundException("id: " + id);
        }

        Usuario usuario = new Usuario(100, "Hateoas");
        Resource<Usuario> recurso = new Resource<Usuario>(usuario);
        ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).obtenerUsuarios());
        recurso.add(linkto.withRel("all-users"));

        return recurso;
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(20, "Roberto"));
        usuarios.add(new Usuario(20, "Mario"));
        usuarios.add(new Usuario(20, "Pedro"));

        return usuarios;
    }

    @PutMapping("/usuarios/{id}")
    public void modificarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        log.info("Usuario Modificado.");
    }


    @GetMapping("/usuarios/i18n")
    public String mensajeInternacional(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return "saludo: " + messageResource.getMessage("message.saludo", null, locale);
    }

    @GetMapping("/usuarios/i18n2")
    public String mensajeInternacional() {
        return "saludo: " + messageResource.getMessage("message.saludo", null, LocaleContextHolder.getLocale());
    }
}