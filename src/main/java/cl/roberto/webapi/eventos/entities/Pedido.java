package cl.roberto.webapi.eventos.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.*;
import java.util.Date;

@Slf4j
@ToString
@NoArgsConstructor
@ApiModel(description = "Entidad pedido")
public class Pedido {

    @ApiModelProperty(notes = "Identificador entidad")
    private int id;
    @Min(value = 2, message = "Min2")
    @Max(value = 100, message = "Max100")
    private int cantidad;
    @Size(min=2, max = 5, message = "El largo debe ser 2-5")
    private String producto;
    @Past private Date fecha;

    public Pedido(int id, int cantidad, String producto, Date fecha) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.fecha = fecha;

        log.info("Nuevo Pedido");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
