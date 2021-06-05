/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Javier
 */
public class Convalidacion {
    String estado,comentarios,Codigo_Asignatura_destino,Codigo_Asignatura_origen;
    Integer id_convalidacion,id_estancia_Estancia;
    public Convalidacion(Integer id_convalidacion, String estado, String comentarios, String Codigo_Asignatura_destino,  String Codigo_Asignatura_origen,Integer id_estancia_Estancia) {
        this.id_convalidacion = id_convalidacion;
        this.estado = estado;
        this.comentarios = comentarios;
        this.id_estancia_Estancia = id_estancia_Estancia;
        this.Codigo_Asignatura_destino = Codigo_Asignatura_destino;
        this.Codigo_Asignatura_origen = Codigo_Asignatura_origen;
    }

    public Integer getId_convalidacion() {
        return id_convalidacion;
    }

    public void setId_convalidacion(Integer id_convalidacion) {
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



    public Integer getId_estancia_Estancia() {
        return id_estancia_Estancia;
    }

    public void setId_estancia_Estancia(Integer id_estancia_Estancia) {
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
