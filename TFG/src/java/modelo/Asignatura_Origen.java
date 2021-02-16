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
public class Asignatura_Origen {
    private Integer codigo, creditos;
    private String nombre, guia_docente;

    public Asignatura_Origen(Integer codigo, Integer creditos, String nombre, String guia_docente) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.nombre = nombre;
        this.guia_docente = guia_docente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGuia_docente() {
        return guia_docente;
    }

    public void setGuia_docente(String guia_docente) {
        this.guia_docente = guia_docente;
    }
    
}
