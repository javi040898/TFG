/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Conexion {

    Connection conn = null;

    public Connection connect() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:"
            + "//localhost:5432/TFG?serverTimezone=UTC", "postgres", "postgres");
            System.out.println("Conectado");
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public void disconnect() {
        try {
            conn.close();
            System.out.println("Desconectado!!");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            
        } catch (Exception ex) {
           System.out.println(ex.toString());
           
        }
    }
    

}
