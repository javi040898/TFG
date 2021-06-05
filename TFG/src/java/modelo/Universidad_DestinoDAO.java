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
public class Universidad_DestinoDAO {

    Connection conexion;

    public Universidad_DestinoDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public boolean insertar(Universidad_Destino universidad) {

        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement("insert into Universidad_Destino values(?,?,?,?)");

            ps.setString(1, universidad.getCodigo_erasmus());
            ps.setString(2, universidad.getNombre());
            ps.setString(3, universidad.getPais());
            ps.setString(4, universidad.getCiudad());
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

    public String obtenerCodigo(String nombre) {

        PreparedStatement ps;
        ResultSet rs;
        String codigo = "";

        try {
            ps = conexion.prepareStatement("select codigo_erasmus from Universidad_destino where nombre = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            while (rs.next()) {
                codigo = rs.getString("codigo");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return codigo;
    }

    public String obtenerNombre(String codigo) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String nombre = "";

        try {
            ps = conexion.prepareStatement("select nombre from Universidad_destino where codigo_erasmus = ?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombre = rs.getString("nombre");
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
        return nombre;
    }

    public List<Universidad_Destino> listarUniversidades() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Universidad_Destino> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("select * from Universidad_destino");
            rs = ps.executeQuery();

            while (rs.next()) {

                String codigo = rs.getString("codigo_erasmus");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                String ciudad = rs.getString("ciudad");

                Universidad_Destino ud = new Universidad_Destino(codigo, nombre, pais, ciudad);

                lista.add(ud);
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
}
