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
public class muchasAsignaturas_muchos_AlumnosDAO {

    Connection conexion;

    public muchasAsignaturas_muchos_AlumnosDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public boolean insertarMama(muchasAsignaturas_muchos_Alumnos mama) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO muchos_Asignatura_origen_tiene_muchos_Alumno VALUES(?,?);");

            ps.setInt(1, mama.getCodigo());
            ps.setString(2, mama.getDNI());

            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;

        }
    }
}
