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
public class ConvalidacionDAO {

    Connection conexion;

    public ConvalidacionDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public void cambiarEstado(String estado, String codigo_asignatura) {
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexion.prepareStatement("UPDATE Convalidacion SET Estado = ? where Codigo_Asignatura_destino = ?");
            ps.setString(1, estado);
            ps.setString(2, codigo_asignatura);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }

    }

    public void setComentarios(String comentarios, String codigo_asignatura) {
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexion.prepareStatement("UPDATE Convalidacion SET Comentarios = ? where Codigo_Asignatura_destino = ?");
            ps.setString(1, comentarios);
            ps.setString(2, codigo_asignatura);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }

    }

    public boolean insertarConvalidacion(Convalidacion c) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO Convalidacion VALUES(?,?,?,CURRENT_DATE,?,?,?);");

            ps.setInt(1, c.getId_convalidacion());
            ps.setString(2, c.getEstado());
            ps.setString(3, c.getComentarios());
            //ps.setDate(4, c.getFecha_convalidacion());
            ps.setInt(4, c.getId_estancia_Estancia());
            ps.setString(5, c.getCodigo_Asignatura_destino());
            ps.setString(6, c.getCodigo_Asignatura_origen());
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;

        }
    }
    
    public Integer obtenerSiguienteConvalidacion() {

        PreparedStatement ps;
        ResultSet rs;
        Integer id_convalidacion = 0;

        try {
            ps = conexion.prepareStatement("select max(id_convalidacion) from Convalidacion");
            rs = ps.executeQuery();

            while (rs.next()) {
                id_convalidacion = rs.getInt("max");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id_convalidacion+1;
    }
}
