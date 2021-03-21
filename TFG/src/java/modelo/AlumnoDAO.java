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
    
    public AlumnoDAO(){
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }
    
    public String obtenerPassword(String usuario){
        
        PreparedStatement ps;
        ResultSet rs;
        String passw = "";
        
        try {
            ps = conexion.prepareStatement("select passw from Alumno where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            while(rs.next()){
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
            ps = conexion.prepareStatement("select * from Alumno where DNI_Profesor = ?;");
            ps.setString(1, DNI_Profesor);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                String contraseña = rs.getString("passw");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String nombre_usuario = rs.getString("Nombre_usuario_Usuario");
                String DNI = rs.getString("DNI");
                String DNI_Prof = rs.getString("DNI_Profesor");

                Alumno alumno = new Alumno(contraseña, nombre, apellidos,nombre_usuario,DNI,DNI_Prof);

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
            
            ps.setString(1, alumno.getContraseña());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellidos());
            ps.setString(4, alumno.getNombre_usuario_Usuario());
            ps.setString(5, alumno.getDNI());
            ps.setString(6, alumno.getDNI_Profesor());
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
    
    public String obtenerDNI(String usuario){
        PreparedStatement ps;
        ResultSet rs;
        String user = "";
        
        try {
            ps = conexion.prepareStatement("select DNI from Alumno where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                user = rs.getString("DNI");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
