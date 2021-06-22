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
public class Asignatura_DestinoDAO {

    Connection conexion;

    public Asignatura_DestinoDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public List<Asignatura_Destino> listarAsignaturas(String DNI) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Asignatura_Destino> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select distinct(asignatura_destino.*) from asignatura_destino inner join universidad_destino on Codigo_erasmus = Asignatura_destino.Codigo_erasmus_Universidad_destino inner join \n"
                    + "estancia on estancia.Codigo_erasmus_Universidad_destino = Codigo_erasmus inner join alumno on DNI = DNI_Alumno where DNI = ? and renuncia = false and cerrada = false order by nombre;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {

                String codigo = rs.getString("codigo");
                Integer creditos = rs.getInt("creditos");
                String nombre = rs.getString("nombre");
                String informacion = rs.getString("informacion");
                String codigo_erasmus_Universidad_destino = rs.getString("codigo_erasmus_Universidad_destino");

                Asignatura_Destino asignatura = new Asignatura_Destino(codigo, creditos, nombre, informacion, codigo_erasmus_Universidad_destino);
                lista.add(asignatura);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
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

    public void cambiarEstado(String estado, Integer codigo_asignatura) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement("UPDATE Asignatura_destino SET Estado = ? where Asignatura_destino.Codigo =?");
            ps.setString(1, estado);
            ps.setInt(2, codigo_asignatura);
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

    public boolean insertarAsignaturaDestino(Asignatura_Destino asignatura) {

        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement("INSERT INTO Asignatura_destino VALUES (?,?,?,?,?);");

            ps.setString(1, asignatura.getCodigo());
            ps.setInt(2, asignatura.getCreditos());
            ps.setString(3, asignatura.getNombre());
            ps.setString(4, asignatura.getInformacion());
            ps.setString(5, asignatura.getCodigo_erasmus_Universidad_destino());

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

    public void desconectar() throws SQLException {
        conexion.close();
        System.out.println("desconectado");
    }

}
