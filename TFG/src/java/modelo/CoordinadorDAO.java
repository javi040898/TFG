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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class CoordinadorDAO {

    Connection conexion;

    public CoordinadorDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public String obtenerDNI(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String user = "";

        try {
            ps = conexion.prepareStatement("select DNI from Coordinador where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = rs.getString("DNI");
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
        return user;
    }

    public String obtenerPassword(String usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String passw = "";

        try {
            ps = conexion.prepareStatement("select Passw from Coordinador where Nombre_usuario_Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                passw = rs.getString("passw");
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
        return passw;
    }

    public String obtenerPassword2(String DNI) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String passw = "";

        try {
            ps = conexion.prepareStatement("select passw from Coordinador where DNI = ?");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                passw = rs.getString("passw");
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
        return passw;
    }

    public boolean cambiarContraseña(String DNI, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement("update Coordinador set Passw = ? where DNI = ?;");
            ps.setString(1, password);
            ps.setString(2, DNI);
            rs = ps.executeQuery();
            conexion.close();
            return true;

        } catch (SQLException ex) {
            return false;
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

    public boolean insertar(Coordinador profesor) {

        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement("insert into Coordinador values(?,?,?,?,?,?)");

            ps.setString(1, profesor.getDNI());
            ps.setString(2, profesor.getContraseña());
            ps.setString(3, profesor.getNombre());
            ps.setString(4, profesor.getApellidos());
            ps.setString(5, profesor.getNombre_usuario_Usuario());
            ps.setString(6, profesor.getDepartamento());
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

    public void desconectar() throws SQLException {
        conexion.close();
        System.out.println("desconectado");
    }

}
