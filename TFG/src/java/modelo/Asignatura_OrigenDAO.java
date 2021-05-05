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

                String codigo = rs.getString("codigo");
                Integer creditos = rs.getInt("creditos");
                String nombre = rs.getString("nombre");
                String informacion = rs.getString("informacion");
                String tipo = rs.getString("tipo");

                Asignatura_Origen asignatura = new Asignatura_Origen(codigo, creditos, nombre, informacion, tipo);
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

    public List<Asignatura_Origen> listarAsignaturasBuscador(String codigo) {
        PreparedStatement ps;
        ResultSet rs;
        List<Asignatura_Origen> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select Asignatura_origen.* from Asignatura_origen inner join Asignatura_destino on "
                    + "Asignatura_origen.codigo=Asignatura_destino.Codigo_Asignatura_origen\n"
                    + "where Asignatura_origen.codigo = ? and estado = 'Aceptada' ;");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {

                Integer creditos = rs.getInt("creditos");
                String nombre = rs.getString("nombre");
                String informacion = rs.getString("informacion");
                String tipo = rs.getString("tipo");

                Asignatura_Origen asignatura = new Asignatura_Origen(codigo, creditos, nombre, informacion, tipo);
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

    public boolean insertarAsignaturaOrigen(Asignatura_Origen asignatura) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO Asignatura_origen VALUES (?,?,?,?);");

            ps.setString(1, asignatura.getCodigo());
            ps.setInt(2, asignatura.getCreditos());
            ps.setString(3, asignatura.getNombre());
            ps.setString(4, asignatura.getInformacion());
            ps.setString(5, asignatura.getTipo());

            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;

        }
    }

    public Integer sumaCreditos(String DNI) {
        PreparedStatement ps;
        ResultSet rs;
        Integer suma_creditos = 0;

        try {
            ps = conexion.prepareStatement("select sum(creditos) as suma_creditos from (select distinct Asignatura_origen.*\n"
                    + "from Convalidacion inner join Estancia on id_estancia_Estancia=id_estancia\n"
                    + "inner join Asignatura_origen on Asignatura_origen.Codigo = Codigo_Asignatura_origen \n"
                    + "inner join Asignatura_destino on Codigo_Asignatura_destino=Asignatura_destino.Codigo where DNI_Alumno= ? ) as asignaturas_distintas;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                suma_creditos = rs.getInt("suma_creditos");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return suma_creditos;
    }

}
