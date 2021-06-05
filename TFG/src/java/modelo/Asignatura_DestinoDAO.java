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

    public List<Asignatura_Destino> listarAsignaturas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Asignatura_Destino> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select * from Asignatura_destino;");
            rs = ps.executeQuery();

            while (rs.next()) {

                String codigo = rs.getString("codigo");
                Integer creditos = rs.getInt("creditos");
                String nombre = rs.getString("nombre");
                String informacion = rs.getString("informacion");
                String codigo_erasmus_Universidad_destino = rs.getString("codigo_erasmus_Universidad_destino");

                Asignatura_Destino asignatura = new Asignatura_Destino(codigo, creditos, nombre, informacion,codigo_erasmus_Universidad_destino);
                lista.add(asignatura);
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

   /*public List<Asignatura_Destino> listarAsignaturasBuscador(Integer codigo) {
        PreparedStatement ps;
        ResultSet rs;
        List<Asignatura_Destino> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select Asignatura_destino.* from Asignatura_origen inner join Asignatura_destino "
                    + "on Asignatura_origen.codigo=Asignatura_destino.Codigo_Asignatura_origen\n"
                    + "where Asignatura_origen.codigo = ? and estado = 'Aceptada' ;");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {

                Integer creditos = rs.getInt("creditos");
                String nombre = rs.getString("nombre");
                String guia_docente = rs.getString("guia_docente");
                Integer codigo_origen = rs.getInt("Codigo_Asignatura_origen");
                String estado = rs.getString("estado");

                Asignatura_Destino asignatura = new Asignatura_Destino(codigo, creditos, codigo_origen, nombre, guia_docente, estado);
                System.out.println("estado" + estado);
                lista.add(asignatura);
            }

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;

        }
    }*/

    public void cambiarEstado(String estado, Integer codigo_asignatura) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement("UPDATE Asignatura_destino SET Estado = ? where Asignatura_destino.Codigo =?");
            ps.setString(1, estado);
            ps.setInt(2, codigo_asignatura);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.toString());

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

    public boolean insertarAsignaturaDestino(Asignatura_Destino asignatura) {

        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement("INSERT INTO Asignatura_destino VALUES (?,?,?,?,?);");

            ps.setString(1, asignatura.getCodigo());
            ps.setInt(2, asignatura.getCreditos());
            ps.setString(3, asignatura.getNombre());
            ps.setString(4, asignatura.getInformacion());
            ps.setString(5, asignatura.getCodigo_erasmus_Universidad_destino());

            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
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

}
