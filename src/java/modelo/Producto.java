/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author arias
 */
public class Producto {
    private int id;
    private String nombre;
    private Categoria categoria;
    private float precio;
    private String descripcion;
    private Date fechaDeIngreso;
    private boolean disponible;
    private Usuario usuario;
    private Talle talle;
    private Genero genero;
    private String nombreFoto;

    public Producto(int id, String nombre, Categoria categoria, float precio, String descripcion, boolean disponible, Usuario usuario, Talle talle, Genero genero, String nombreFoto) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.usuario = usuario;
        this.talle = talle;
        this.genero = genero;
        this.nombreFoto = nombreFoto;
    }
    
    public Producto( ) {

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + ", descripcion=" + descripcion + ", fechaDeIngreso=" + fechaDeIngreso + ", disponible=" + disponible + ", usuario=" + usuario + ", talle=" + talle + ", genero=" + genero + '}';
    }

    
    

}
