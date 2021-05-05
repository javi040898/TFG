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
    
    public List<Universidad_Destino> listarUniversidades() {

        PreparedStatement ps;
        ResultSet rs;
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

        }
    }
}
