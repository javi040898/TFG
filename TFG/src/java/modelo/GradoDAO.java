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
public class GradoDAO {

    Connection conexion;

    public GradoDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public boolean insertar(Grado grado) {

        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement("insert into Grado values(?,?,?)");

            ps.setString(1, grado.getCodigo());
            ps.setString(2, grado.getNombre());
            ps.setString(3, grado.getFacultad());
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

    public List<Grado> listarGrados() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Grado> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("select * from Grado");
            rs = ps.executeQuery();

            while (rs.next()) {

                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String facultad = rs.getString("facultad");

                Grado grado = new Grado(codigo, nombre, facultad);

                lista.add(grado);
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

    public Grado gradoAlumno(String DNI) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Grado grado = null;

        try {
            ps = conexion.prepareStatement("select Grado.* from Grado inner join Alumno on Codigo_Grado = Codigo where DNI = ?;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {

                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String facultad = rs.getString("facultad");

                grado = new Grado(codigo, nombre, facultad);

            }

            return grado;
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

    public void desconectar() throws SQLException {
        conexion.close();
        System.out.println("desconectado");
    }
}
