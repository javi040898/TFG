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
public class Asignatura_Destino {
    private Integer codigo, creditos, codigo_Asignatura_Origen;
    private String nombre, guia_docente, estado;

    public Asignatura_Destino(Integer codigo, Integer creditos, Integer codigo_Asignatura_Origen, String nombre, String guia_docente, String estado) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.codigo_Asignatura_Origen = codigo_Asignatura_Origen;
        this.nombre = nombre;
        this.guia_docente = guia_docente;
        this.estado = estado;
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

    public Integer getCodigo_Asignatura_Origen() {
        return codigo_Asignatura_Origen;
    }

    public void setCodigo_Asignatura_Origen(Integer codigo_Asignatura_Origen) {
        this.codigo_Asignatura_Origen = codigo_Asignatura_Origen;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
