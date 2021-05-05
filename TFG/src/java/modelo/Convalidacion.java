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
public class Convalidacion {
    String id_convalidacion,estado,comentarios,fecha_convalidacion,id_estancia_Estancia,Codigo_Asignatura_destino,Codigo_Asignatura_origen;

    public Convalidacion(String id_convalidacion, String estado, String comentarios, String fecha_convalidacion, String id_estancia_Estancia, String Codigo_Asignatura_destino, String Codigo_Asignatura_origen) {
        this.id_convalidacion = id_convalidacion;
        this.estado = estado;
        this.comentarios = comentarios;
        this.fecha_convalidacion = fecha_convalidacion;
        this.id_estancia_Estancia = id_estancia_Estancia;
        this.Codigo_Asignatura_destino = Codigo_Asignatura_destino;
        this.Codigo_Asignatura_origen = Codigo_Asignatura_origen;
    }

    public String getId_convalidacion() {
        return id_convalidacion;
    }

    public void setId_convalidacion(String id_convalidacion) {
        this.id_convalidacion = id_convalidacion;
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

    public String getFecha_convalidacion() {
        return fecha_convalidacion;
    }

    public void setFecha_convalidacion(String fecha_convalidacion) {
        this.fecha_convalidacion = fecha_convalidacion;
    }

    public String getId_estancia_Estancia() {
        return id_estancia_Estancia;
    }

    public void setId_estancia_Estancia(String id_estancia_Estancia) {
        this.id_estancia_Estancia = id_estancia_Estancia;
    }

    public String getCodigo_Asignatura_destino() {
        return Codigo_Asignatura_destino;
    }

    public void setCodigo_Asignatura_destino(String Codigo_Asignatura_destino) {
        this.Codigo_Asignatura_destino = Codigo_Asignatura_destino;
    }

    public String getCodigo_Asignatura_origen() {
        return Codigo_Asignatura_origen;
    }

    public void setCodigo_Asignatura_origen(String Codigo_Asignatura_origen) {
        this.Codigo_Asignatura_origen = Codigo_Asignatura_origen;
    }
    
}
