/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author arias
 */
public class Venta {
    private int id;
    private Date fecha;
    private Producto producto;
    private FormaDePago formaDePago;
    private Usuario comprador;
    private Usuario vendedor;
    private boolean cancelado;
    private int valoracion;

    public Venta(int id, Date fecha, Producto producto, FormaDePago formaDePago, Usuario comprador, Usuario vendedor, boolean cancelado) {
        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.formaDePago = formaDePago;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.cancelado = cancelado;
        this.valoracion = buscarValoracion(id);
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
    
    public int buscarValoracion(int id) {
        return new GestorDB().buscarValoracion(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

}
