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

    public List<Grado> listarGrados() {

        PreparedStatement ps;
        ResultSet rs;
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

        }
    }
}