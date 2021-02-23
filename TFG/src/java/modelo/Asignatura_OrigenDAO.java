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
public class Asignatura_OrigenDAO {

    Connection conexion;

    public Asignatura_OrigenDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public List<Asignatura_Origen> listarAsignaturas(String DNI) {
        PreparedStatement ps;
        ResultSet rs;
        List<Asignatura_Origen> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select Asignatura_origen.* from Asignatura_origen inner join muchos_Asignatura_origen_tiene_muchos_Alumno on \n"
                    + "Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen\n"
                    + "inner join Alumno on Alumno.DNI=muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno where DNI=?;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {

                Integer codigo = rs.getInt("codigo");
                Integer creditos = rs.getInt("creditos");
                String nombre = rs.getString("nombre");
                String guia_docente = rs.getString("guia_docente");

                Asignatura_Origen asignatura = new Asignatura_Origen(codigo, creditos, nombre, guia_docente);
                //System.out.println("codigo"+codigo);
                //System.out.println("creditos"+creditos);
                //System.out.println("nombre"+nombre);
                //System.out.println("guia_docente"+guia_docente);

                lista.add(asignatura);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;

        }
    }

    

}
