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
    private String contraseña,nombre,apellidos, nombre_usuario_Usuario, DNI, DNI_Profesor;

    public Alumno(String contraseña, String nombre, String apellidos, String nombre_usuario_Usuario, String DNI, String DNI_Profesor) {
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombre_usuario_Usuario = nombre_usuario_Usuario;
        this.DNI = DNI;
        this.DNI_Profesor = DNI_Profesor;
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

    public String getDNI_Profesor() {
        return DNI_Profesor;
    }

    public void setDNI_Porfesor(String DNI_Profesor) {
        this.DNI_Profesor = DNI_Profesor;
    }

    @Override
    public String toString() {
        return "Alumno{" + "contrase\u00f1a=" + contraseña + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nombre_usuario_Usuario=" + nombre_usuario_Usuario + ", DNI=" + DNI + ", DNI_Profesor=" + DNI_Profesor + '}';
    }
    
    
}
