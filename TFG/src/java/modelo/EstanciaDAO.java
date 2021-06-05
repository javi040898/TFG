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
public class EstanciaDAO {

    Connection conexion;

    public EstanciaDAO() {
        Conexion conn = new Conexion();
        conexion = conn.connect();
    }

    public boolean insertar(Estancia estancia) {

        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement("insert into Estancia values(?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, estancia.getId_estancia());
            ps.setString(2, estancia.getTipo());
            ps.setString(3, estancia.getCurso_academico());
            ps.setString(4, estancia.getDuracion());
            ps.setBoolean(5, estancia.getRenuncia());
            ps.setBoolean(6, estancia.getCerrada());
            ps.setString(7, estancia.getCodigo_erasmus_Universidad_destino());
            ps.setString(8, estancia.getDNI_coordinador());
            ps.setString(9, estancia.getDNI_alumno());

            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            System.out.println("No se ha insertado");
            return false;
        }
        finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public Integer obtenerSiguienteEstancia() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id_estancia = 0;

        try {
            ps = conexion.prepareStatement("select max(id_estancia) from Estancia");
            rs = ps.executeQuery();

            while (rs.next()) {
                id_estancia = rs.getInt("max");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
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
        return id_estancia + 1;
    }

    public String obtenerCodigoUniversidadDestino(String DNI) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String codigo_erasmus_Universidad_destino = "";

        try {
            ps = conexion.prepareStatement("select Codigo_erasmus_Universidad_destino from estancia where DNI_Alumno= ?;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                codigo_erasmus_Universidad_destino = rs.getString("Codigo_erasmus_Universidad_destino");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
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
        return codigo_erasmus_Universidad_destino;
    }

    public Integer obtenerIdEstancia(String DNI) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id_estancia = 0;

        try {
            ps = conexion.prepareStatement("select id_estancia from estancia where DNI_Alumno= ?;");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                id_estancia = rs.getInt("id_estancia");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
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
        return id_estancia;
    }

    public List<Estancia> obtenerEstanciaYUniversidad(String DNI) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Estancia> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("select Estancia.* from Estancia  where dni_alumno = ? and cerrada='false';");
            ps.setString(1, DNI);
            rs = ps.executeQuery();

            while (rs.next()) {
                Integer id_estancia = rs.getInt("id_estancia");
                String tipo = rs.getString("tipo");
                String curso_academico = rs.getString("curso_academico");
                String duracion = rs.getString("duracion");
                Boolean renuncia = rs.getBoolean("renuncia");
                Boolean cerrada = rs.getBoolean("cerrada");
                String codigo_erasmus_universidad_destino = rs.getString("codigo_erasmus_universidad_destino");
                String dni_coordinador = rs.getString("dni_coordinador");
                String dni_alumno = rs.getString("dni_alumno");

                Estancia estancia = new Estancia(id_estancia, tipo, curso_academico, duracion, renuncia, cerrada, codigo_erasmus_universidad_destino, dni_coordinador, dni_alumno);

                lista.add(estancia);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        finally {

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
}
