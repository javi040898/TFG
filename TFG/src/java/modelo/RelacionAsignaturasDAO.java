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
public class RelacionAsignaturasDAO {

    Connection conexion;

    public RelacionAsignaturasDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public List<RelacionAsignaturas> listarConvalidaciones(String DNI) {
        PreparedStatement ps;
        ResultSet rs;
        List<RelacionAsignaturas> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select Codigo_Asignatura_origen,Asignatura_origen.nombre,Asignatura_origen.tipo,Asignatura_origen.creditos,Asignatura_origen.informacion,\n"
                    + "Codigo_Asignatura_destino,Asignatura_destino.nombre as nombre_destino,Asignatura_destino.creditos as creditos_destino,\n"
                    + "Asignatura_destino.informacion as informacion_destino,\n"
                    + "fecha_convalidacion,curso_academico,\n"
                    + "estado,comentarios\n"
                    + "from Convalidacion inner join Estancia on id_estancia_Estancia=id_estancia\n"
                    + "inner join Asignatura_origen on Asignatura_origen.Codigo = Codigo_Asignatura_origen \n"
                    + "inner join Asignatura_destino on Codigo_Asignatura_destino=Asignatura_destino.Codigo where DNI_Alumno=?");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {

                String codigo_origen = rs.getString("Codigo_Asignatura_origen");
                String nombre_origen = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                Integer creditos_origen = rs.getInt("creditos");
                String informacion_origen = rs.getString("informacion");
                String codigo_destino = rs.getString("Codigo_Asignatura_destino");
                String nombre_destino = rs.getString("nombre_destino");

                Integer creditos_destino = rs.getInt("creditos_destino");
                String informacion_destino = rs.getString("informacion_destino");

                String fecha = rs.getString("fecha_convalidacion");
                String curso = rs.getString("curso_academico");
                String estado = rs.getString("estado");
                String comentarios = rs.getString("comentarios");

                RelacionAsignaturas ra = new RelacionAsignaturas(codigo_origen, nombre_origen, tipo, informacion_origen,
                        codigo_destino, nombre_destino, informacion_destino, fecha, curso, estado, comentarios, creditos_origen, creditos_destino);

                lista.add(ra);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;

        }
    }

}
