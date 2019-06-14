package cl.roberto.webapi.eventos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    private int id;
    private String nombre;

}
