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
public class RelacionAsignaturas {

    String codigo_origen, nombre_origen, tipo,  informacion_origen,codigo_destino, nombre_destino,informacion_destino,fecha,curso,estado,comentarios,nombre_universidad;
    Integer creditos_origen,creditos_destino;

    public RelacionAsignaturas(String codigo_origen, String nombre_origen, String tipo, String informacion_origen, 
            String codigo_destino, String nombre_destino, String informacion_destino, String fecha, String curso, 
            String estado, String comentarios, Integer creditos_origen, Integer creditos_destino,String nombre_universidad) {
        this.codigo_origen = codigo_origen;
        this.nombre_origen = nombre_origen;
        this.tipo = tipo;
        this.informacion_origen = informacion_origen;
        this.codigo_destino = codigo_destino;
        this.nombre_destino = nombre_destino;
        this.informacion_destino = informacion_destino;
        this.fecha = fecha;
        this.curso = curso;
        this.estado = estado;
        this.comentarios = comentarios;
        this.creditos_origen = creditos_origen;
        this.creditos_destino = creditos_destino;
        this.nombre_universidad = nombre_universidad;
    }

    public String getCodigo_origen() {
        return codigo_origen;
    }

    public void setCodigo_origen(String codigo_origen) {
        this.codigo_origen = codigo_origen;
    }

    public String getNombre_origen() {
        return nombre_origen;
    }

    public void setNombre_origen(String nombre_origen) {
        this.nombre_origen = nombre_origen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInformacion_origen() {
        return informacion_origen;
    }

    public void setInformacion_origen(String informacion_origen) {
        this.informacion_origen = informacion_origen;
    }

    public String getCodigo_destino() {
        return codigo_destino;
    }

    public void setCodigo_destino(String codigo_destino) {
        this.codigo_destino = codigo_destino;
    }

    public String getNombre_destino() {
        return nombre_destino;
    }

    public void setNombre_destino(String nombre_destino) {
        this.nombre_destino = nombre_destino;
    }

    public String getInformacion_destino() {
        return informacion_destino;
    }

    public void setInformacion_destino(String informacion_destino) {
        this.informacion_destino = informacion_destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getCreditos_origen() {
        return creditos_origen;
    }

    public void setCreditos_origen(Integer creditos_origen) {
        this.creditos_origen = creditos_origen;
    }

    public Integer getCreditos_destino() {
        return creditos_destino;
    }

    public void setCreditos_destino(Integer creditos_destino) {
        this.creditos_destino = creditos_destino;
    }

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }
    
    
    
}
