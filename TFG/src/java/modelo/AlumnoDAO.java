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
public class AlumnoDAO {

    Connection conexion;

    public AlumnoDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public String obtenerPassword(String usuario) {

        PreparedStatement ps;
        ResultSet rs;
        String passw = "";

        try {
            ps = conexion.prepareStatement("select passw from Alumno where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                passw = rs.getString("passw");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return passw;
    }

    public String obtenerPassword2(String DNI) {

        PreparedStatement ps;
        ResultSet rs;
        String passw = "";

        try {
            ps = conexion.prepareStatement("select passw from Alumno where DNI = ?");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                passw = rs.getString("passw");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return passw;
    }

    public List<Alumno> listarAlumnos(String DNI_Profesor) {

        PreparedStatement ps;
        ResultSet rs;
        List<Alumno> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT Alumno.* from Alumno inner join Estancia on DNI_Alumno=Alumno.DNI \n"
                    + "inner join Coordinador on DNI_Coordinador=Coordinador.DNI where Coordinador.DNI= ?;");
            ps.setString(1, DNI_Profesor);
            rs = ps.executeQuery();

            while (rs.next()) {

                String contraseña = rs.getString("passw");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String nombre_usuario = rs.getString("Nombre_usuario_Usuario");
                String DNI = rs.getString("DNI");
                String codigo_grado = rs.getString("codigo_grado");

                Alumno alumno = new Alumno(DNI,nombre, apellidos,contraseña, nombre_usuario,  codigo_grado);

                lista.add(alumno);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;

        }
    }

    public boolean insertar(Alumno alumno) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("insert into Alumno values(?,?,?,?,?,?)");
            
            ps.setString(1, alumno.getDNI());
            ps.setString(2, alumno.getContraseña());
            ps.setString(3, alumno.getNombre());
            ps.setString(4, alumno.getApellidos());
            ps.setString(5, alumno.getNombre_usuario_Usuario());
            ps.setString(6, alumno.getCodigo_grado());
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;

        }
    }

    public List<Integer> listarCodigosAsignaturasAlumno(String DNI) {
        PreparedStatement ps;
        ResultSet rs;
        List<Integer> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select ad.Codigo from Asignatura_destino ad inner join Asignatura_origen on \n"
                    + "Asignatura_origen.codigo=ad.Codigo_Asignatura_origen inner join\n"
                    + "muchos_Asignatura_origen_tiene_muchos_Alumno on \n"
                    + "Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen\n"
                    + "where muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno=?;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {

                Integer codigo = rs.getInt("codigo");
                lista.add(codigo);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;

        }
    }

    public String obtenerDNI(String usuario) {
        PreparedStatement ps;
        ResultSet rs;
        String user = "";

        try {
            ps = conexion.prepareStatement("select DNI from Alumno where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = rs.getString("DNI");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
    
     public String obtenerNombre(String DNI) {
        PreparedStatement ps;
        ResultSet rs;
        String cadena = "";

        try {
            ps = conexion.prepareStatement("select Nombre from Alumno where DNI = ?");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                cadena = rs.getString("Nombre");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cadena;
    }
     public String obtenerApellidos(String DNI) {
        PreparedStatement ps;
        ResultSet rs;
        String cadena = "";

        try {
            ps = conexion.prepareStatement("select Apellidos from Alumno where DNI = ?");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                cadena = rs.getString("Apellidos");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cadena;
    }

    public boolean cambiarContraseña(String DNI, String password) {
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexion.prepareStatement("update Alumno set Passw = ? where DNI = ?;");
            ps.setString(1, password);
            ps.setString(2, DNI);
            rs = ps.executeQuery();
            return true;

        } catch (SQLException ex) {
            return false;
        }

    }
}
