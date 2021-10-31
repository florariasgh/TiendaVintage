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
public class FormaDePago {
    private int id;
    private String nombre;

    public FormaDePago(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public FormaDePago() {}
    
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

    @Override
    public String toString() {
        return "FormaDePago{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    

    
    
}
