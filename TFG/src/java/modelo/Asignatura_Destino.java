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
    private Integer creditos;
    private String nombre, informacion,codigo,Codigo_erasmus_Universidad_destino;

    public Asignatura_Destino(String codigo, Integer creditos, String nombre, String informacion, String codigo_erasmus_Universidad_destino) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.Codigo_erasmus_Universidad_destino = codigo_erasmus_Universidad_destino;
        this.nombre = nombre;
        this.informacion = informacion;

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

    


    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_erasmus_Universidad_destino() {
        return Codigo_erasmus_Universidad_destino;
    }

    public void setCodigo_erasmus_Universidad_destino(String Codigo_erasmus_Universidad_destino) {
        this.Codigo_erasmus_Universidad_destino = Codigo_erasmus_Universidad_destino;
    }
    
    
}
