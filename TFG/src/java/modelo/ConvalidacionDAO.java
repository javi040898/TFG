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

    public void cambiarEstado(String estado, Integer id_convalidacion) {
        System.out.println("entro a cambair estado");
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement("UPDATE Convalidacion SET Estado = ? where id_convalidacion = ?");
            ps.setString(1, estado);
            ps.setInt(2, id_convalidacion);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    public void setComentarios(String comentarios, Integer id_convalidacion) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement("UPDATE Convalidacion SET Comentarios = ? where id_convalidacion = ?");
            ps.setString(1, comentarios);
            ps.setInt(2, id_convalidacion);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    public boolean insertarConvalidacion(Convalidacion c) {

        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement("INSERT INTO Convalidacion VALUES(?,?,?,CURRENT_DATE,?,?,?);");

            ps.setInt(1, c.getId_convalidacion());
            ps.setString(2, c.getEstado());
            ps.setString(3, c.getComentarios());
            //ps.setDate(4, c.getFecha_convalidacion());
            ps.setInt(6, c.getId_estancia_Estancia());
            ps.setString(4, c.getCodigo_Asignatura_destino());
            ps.setString(5, c.getCodigo_Asignatura_origen());
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public Integer obtenerSiguienteConvalidacion() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id_convalidacion = 0;

        try {
            ps = conexion.prepareStatement("select max(id_convalidacion) from Convalidacion");
            rs = ps.executeQuery();

            while (rs.next()) {
                id_convalidacion = rs.getInt("max");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return id_convalidacion + 1;
    }

    public void desconectar() throws SQLException {
        conexion.close();
        System.out.println("desconectado");
    }
}
