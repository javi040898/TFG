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
public class Coordinador {
    private String contraseña,nombre,apellidos,nombre_usuario_Usuario,DNI,departamento;

    
    
    public Coordinador( String DNI,String contraseña, String nombre, String apellidos, String nombre_usuario_Usuario,String departamento ) {
        
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombre_usuario_Usuario = nombre_usuario_Usuario;
        this.DNI = DNI;
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
