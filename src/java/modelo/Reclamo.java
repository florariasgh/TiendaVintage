/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author arias
 */
public class Reclamo {
    
    private int id;
    private String descripcion;
    private Venta venta;
    private Usuario comprador;
    private Usuario vendedor;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Reclamo(int id, String descripcion, Venta venta, Usuario comprador, Usuario vendedor) {
        this.id = id;
        this.descripcion = descripcion;
        this.venta = venta;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
    
}
