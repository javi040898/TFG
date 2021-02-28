/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class ProfesorDAO {
    
    Connection conexion;
    
    public ProfesorDAO(){
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }
    
    public String obtenerDNI(String usuario){
        PreparedStatement ps;
        ResultSet rs;
        String user = "";
        
        try {
            ps = conexion.prepareStatement("select DNI from Profesor where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                user = rs.getString("DNI");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
    
    
    public String obtenerPassword(String usuario){
        
        PreparedStatement ps;
        ResultSet rs;
        String passw = "";
        
        try {
            ps = conexion.prepareStatement("select passw from Profesor where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                passw = rs.getString("passw");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return passw;
    }
    
    public List<Profesor> listarProfesores() {

        PreparedStatement ps;
        ResultSet rs;
        List<Profesor> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("select * from Profesor;");
            rs = ps.executeQuery();

            while (rs.next()) {
                
                String contraseña = rs.getString("passw");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String nombre_usuario = rs.getString("Nombre_usuario_Usuario");
                String DNI = rs.getString("DNI");

                Profesor profesor = new Profesor(contraseña, nombre, apellidos,nombre_usuario,DNI);

                lista.add(profesor);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;

        }
    }
    public boolean insertar(Profesor profesor) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("insert into Profesor values(?,?,?,?,?)");
            
            ps.setString(1, profesor.getContraseña());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getApellidos());
            ps.setString(4, profesor.getNombre_usuario_Usuario());
            ps.setString(5, profesor.getDNI());
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;

        }
    }
    
}
