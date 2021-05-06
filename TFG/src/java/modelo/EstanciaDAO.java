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

/**
 *
 * @author Javier
 */
public class EstanciaDAO {
    Connection conexion;

    public EstanciaDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }
    
    public boolean insertar(Estancia estancia) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("insert into Estancia values(?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, estancia.getId_estancia());
            ps.setString(2, estancia.getTipo());
            ps.setString(3, estancia.getCurso_academico());
            ps.setString(4, estancia.getDuracion());
            ps.setBoolean(5, estancia.getRenuncia());
            ps.setString(6, estancia.getDNI_alumno());
            ps.setString(7, estancia.getDNI_coordinador());
            ps.setString(8, estancia.getCodigo_erasmus_Universidad_destino());
            
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            System.out.println("No se ha insertado");
            return false;

        }
    }
    

    
    public Integer obtenerSiguienteEstancia() {

        PreparedStatement ps;
        ResultSet rs;
        Integer id_estancia = 0;

        try {
            ps = conexion.prepareStatement("select max(id_estancia) from Estancia");
            rs = ps.executeQuery();

            while (rs.next()) {
                id_estancia = rs.getInt("max");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id_estancia+1;
    }
    
    public String obtenerCodigoUniversidadDestino(String DNI) {

        PreparedStatement ps;
        ResultSet rs;
        String codigo_erasmus_Universidad_destino = "";

        try {
            ps = conexion.prepareStatement("select Codigo_erasmus_Universidad_destino from estancia where DNI_Alumno= ?;");
             ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                codigo_erasmus_Universidad_destino = rs.getString("Codigo_erasmus_Universidad_destino");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return codigo_erasmus_Universidad_destino;
    }
    
    public Integer obtenerIdEstancia(String DNI) {

        PreparedStatement ps;
        ResultSet rs;
        Integer id_estancia = 0;

        try {
            ps = conexion.prepareStatement("select id_estancia from estancia where DNI_Alumno= ?;");
             ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                id_estancia = rs.getInt("id_estancia");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id_estancia;
    }
}
