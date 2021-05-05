/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Javier
 */
public class Universidad_Destino {
    String codigo_erasmus,nombre,pais,ciudad;

    public Universidad_Destino(String codigo_erasmus, String nombre, String pais, String ciudad) {
        this.codigo_erasmus = codigo_erasmus;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public String getCodigo_erasmus() {
        return codigo_erasmus;
    }

    public void setCodigo_erasmus(String codigo_erasmus) {
        this.codigo_erasmus = codigo_erasmus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
