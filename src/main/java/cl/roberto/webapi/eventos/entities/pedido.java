package cl.roberto.webapi.eventos.entities;

import java.util.Date;

public class pedido {

    private int id;
    private int cantidad;
    private String producto;
    private Date fecha;

    public pedido(int id, int cantidad, String producto, Date fecha) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.fecha = fecha;
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
