/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class UsuarioDAO {
    
     Connection conexion;
    
    public UsuarioDAO(){
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }
    
    public boolean insertar(Usuario usuario) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("insert into Usuario values(?)");
            
            ps.setString(1, usuario.getNombre_usuario());
            
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;

        }
    }
    
}
