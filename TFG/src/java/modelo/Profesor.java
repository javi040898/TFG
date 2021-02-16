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
public class Profesor {
    private String contraseña,nombre,apellidos,nombre_usuario_Usuario,DNI;
    
    public Profesor(String contraseña, String nombre, String apellidos, String nombre_usuario_Usuario, String DNI ) {
        
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombre_usuario_Usuario = nombre_usuario_Usuario;
        this.DNI = DNI;
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
    

    
    
}
