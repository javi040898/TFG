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
        PreparedStatement ps;
        ResultSet rs;
        List<Asignatura_Destino> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select Asignatura_destino.* from Asignatura_origen inner join muchos_Asignatura_origen_tiene_muchos_Alumno on \n"
                    + "Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen\n"
                    + "inner join Alumno on Alumno.DNI=muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno inner join Asignatura_destino\n"
                    + "on Asignatura_destino.Codigo_Asignatura_origen=Asignatura_origen.Codigo\n"
                    + "where DNI=?;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {

                Integer codigo = rs.getInt("codigo");
                Integer creditos = rs.getInt("creditos");
                String nombre = rs.getString("nombre");
                String guia_docente = rs.getString("guia_docente");
                Integer codigo_origen = rs.getInt("Codigo_Asignatura_origen");
                String estado = rs.getString("estado");

                Asignatura_Destino asignatura = new Asignatura_Destino(codigo, creditos, codigo_origen, nombre, guia_docente,estado);

                lista.add(asignatura);
            }
            

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;

        }
    }

}
