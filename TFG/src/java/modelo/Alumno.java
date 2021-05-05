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
public class Alumno {
    private String DNI,contraseña,nombre,apellidos, nombre_usuario_Usuario,  codigo_grado;

    public Alumno(String DNI,String nombre,String apellidos,String contraseña,   String nombre_usuario_Usuario, String codigo_grado) {
        this.DNI = DNI;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombre_usuario_Usuario = nombre_usuario_Usuario;
        this.codigo_grado = codigo_grado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre_usuario_Usuario() {
        return nombre_usuario_Usuario;
    }

    public void setNombre_usuario_Usuario(String nombre_usuario_Usuario) {
        this.nombre_usuario_Usuario = nombre_usuario_Usuario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCodigo_grado() {
        return codigo_grado;
    }

    public void setCodigo_grado(String codigo_grado) {
        this.codigo_grado = codigo_grado;
    }

    

    @Override
    public String toString() {
        return "Alumno{" + "contrase\u00f1a=" + contraseña + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nombre_usuario_Usuario=" + nombre_usuario_Usuario + ", DNI=" + DNI + ", codigo_grado=" + codigo_grado + '}';
    }
    
    
}
