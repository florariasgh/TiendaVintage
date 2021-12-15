/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author arias
 */
public class ReporteVendedoresItem {
    private String nombre;
    private int cantidad;
    private float valoracion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public ReporteVendedoresItem(String nombre, int cantidad, float valoracion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valoracion = valoracion;
    }
    
}
