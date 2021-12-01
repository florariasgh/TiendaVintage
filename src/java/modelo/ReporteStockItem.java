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
public class ReporteStockItem {
    private Categoria categoria;
    private Talle talle;
    private Genero genero;
    private int cantidad;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ReporteStockItem(Categoria categoria, Talle talle, Genero genero, int cantidad) {
        this.categoria = categoria;
        this.talle = talle;
        this.genero = genero;
        this.cantidad = cantidad;
    }
}
