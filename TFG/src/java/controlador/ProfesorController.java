/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.Asignatura_Destino;
import modelo.Asignatura_DestinoDAO;
import modelo.Asignatura_Origen;
import modelo.Asignatura_OrigenDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;

/**
 *
 * @author Javier
 */
@WebServlet(name = "ProfesorController", urlPatterns = {"/ProfesorController"})
public class ProfesorController extends HttpServlet {

    String usuario = "";
    String DNI_Alumno = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        Asignatura_OrigenDAO asignatura_origenDAO = new Asignatura_OrigenDAO();
        Asignatura_DestinoDAO asignatura_destinoDAO = new Asignatura_DestinoDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/login.jsp");
            System.out.println(dispatcher);
            //List<Profesor> listaProfesores = profesorDAO.listarProfesores();
            //request.setAttribute("lista", listaProfesores);

        } else if ("comprobarLogin".equals(accion)) {
            //response.sendRedirect("profesor.jsp");
            System.out.println("hola");

            String password = request.getParameter("password");
            usuario = request.getParameter("usuario");
            //System.out.println(profesorDAO.obtenerPassword(usuario));
            //System.out.println(password);
            if (profesorDAO.obtenerPassword(usuario) == null ? password == null : profesorDAO.obtenerPassword(usuario).equals(password)) {
                String DNI_Profesor = profesorDAO.obtenerDNI(usuario);
                List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Profesor);
                request.setAttribute("listaAlumnos", alumnos);
                //String DNI_Profesor = profesorDAO.obtenerDNI(usuario);
                //List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Profesor);
                //request.setAttribute("listaAlumnos", alumnos);

                dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

            } else if (alumnoDAO.obtenerPassword(usuario) == null ? password == null : alumnoDAO.obtenerPassword(usuario).equals(password)) {
                dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("ACUERDOS/login.jsp");
            }

            //String usuario = request.getParameter("usuario");
            //request.setAttribute("usuario", usuario);
        } else if ("listarAlumnos".equals(accion)) {
            
            if(!request.getParameter("listaAlumnos").equals("Escoge un alumno")){
                DNI_Alumno = request.getParameter("listaAlumnos");
            }
                
            
            System.out.println("DNI:"+DNI_Alumno);
            List<Asignatura_Origen> listaAsignaturas_origen = asignatura_origenDAO.listarAsignaturas(DNI_Alumno);
            List<Asignatura_Destino> listaAsignaturas_destino = asignatura_destinoDAO.listarAsignaturas(DNI_Alumno);
            dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");
            request.setAttribute("listaAsignaturasOrigen", listaAsignaturas_origen);
            request.setAttribute("listaAsignaturasDestino", listaAsignaturas_destino);
            //System.out.println("fdsf" + usuario);
            String DNI_Profesor = profesorDAO.obtenerDNI(usuario);
            //System.out.println("dsf" + DNI_Profesor);
            List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Profesor);
            request.setAttribute("listaAlumnos", alumnos);
            String estado = request.getParameter("CambiarEstado");
            //System.out.println(estado);
            String codigoAsignaturaAceptar = request.getParameter("listaAsignaturasAceptar");
            String codigoAsignaturaRechazar = request.getParameter("listaAsignaturasRechazar");
            System.out.println("codigo:"+codigoAsignaturaAceptar);
            System.out.println(alumnoDAO.listarCodigosAsignaturasAlumno(DNI_Alumno));
            List<Integer> listaCodigosAsignaturasAlumno = alumnoDAO.listarCodigosAsignaturasAlumno(DNI_Alumno);
            if(!codigoAsignaturaAceptar.equals("Escoge una asignatura")){
                if(listaCodigosAsignaturasAlumno.contains(Integer.parseInt(codigoAsignaturaAceptar))){
                    System.out.println("entro1234");
                    asignatura_destinoDAO.cambiarEstado("Aceptada", Integer.parseInt(codigoAsignaturaAceptar));
                }
            
                
            }
            
            if(!codigoAsignaturaRechazar.equals("Escoge una asignatura")){
                if(listaCodigosAsignaturasAlumno.contains(Integer.parseInt(codigoAsignaturaRechazar))){
                    System.out.println("entro1234");
                    asignatura_destinoDAO.cambiarEstado("Rechazada", Integer.parseInt(codigoAsignaturaRechazar));
                }
            
                
            }
            

            //response.sendRedirect("profesor.jsp");
            //dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");
            //String usuario = request.getParameter("usuario");
            //request.setAttribute("usuario", usuario);
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
