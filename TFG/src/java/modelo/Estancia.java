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
public class Estancia {
    Integer id_estancia;
    String tipo,curso_academico,duracion,DNI_alumno,DNI_coordinador,Codigo_erasmus_Universidad_destino;
    Boolean renuncia;

    public Estancia(Integer id_estancia, String tipo, String curso_academico, String duracion, Boolean renuncia,String DNI_alumno, String DNI_coordinador, String Codigo_erasmus_Universidad_destino) {
        this.id_estancia = id_estancia;
        this.tipo = tipo;
        this.curso_academico = curso_academico;
        this.duracion = duracion;
        this.DNI_alumno = DNI_alumno;
        this.DNI_coordinador = DNI_coordinador;
        this.Codigo_erasmus_Universidad_destino = Codigo_erasmus_Universidad_destino;
        this.renuncia = renuncia;
    }

    public Integer getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(Integer id_estancia) {
        this.id_estancia = id_estancia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCurso_academico() {
        return curso_academico;
    }

    public void setCurso_academico(String curso_academico) {
        this.curso_academico = curso_academico;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDNI_alumno() {
        return DNI_alumno;
    }

    public void setDNI_alumno(String DNI_alumno) {
        this.DNI_alumno = DNI_alumno;
    }

    public String getDNI_coordinador() {
        return DNI_coordinador;
    }

    public void setDNI_coordinador(String DNI_coordinador) {
        this.DNI_coordinador = DNI_coordinador;
    }

    public String getCodigo_erasmus_Universidad_destino() {
        return Codigo_erasmus_Universidad_destino;
    }

    public void setCodigo_erasmus_Universidad_destino(String Codigo_erasmus_Universidad_destino) {
        this.Codigo_erasmus_Universidad_destino = Codigo_erasmus_Universidad_destino;
    }

    public Boolean getRenuncia() {
        return renuncia;
    }

    public void setRenuncia(Boolean renuncia) {
        this.renuncia = renuncia;
    }
    
}
