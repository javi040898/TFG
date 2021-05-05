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
import modelo.ConvalidacionDAO;
import modelo.Coordinador;
import modelo.CoordinadorDAO;
import modelo.Estancia;
import modelo.EstanciaDAO;
import modelo.Grado;
import modelo.GradoDAO;
import modelo.RelacionAsignaturas;
import modelo.RelacionAsignaturasDAO;
import modelo.Universidad_Destino;
import modelo.Universidad_DestinoDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import modelo.muchasAsignaturas_muchos_Alumnos;
import modelo.muchasAsignaturas_muchos_AlumnosDAO;

/**
 *
 * @author Javier
 */
@WebServlet(name = "ProfesorController", urlPatterns = {"/ProfesorController"})
public class ProfesorController extends HttpServlet {

    String usuario = "";
    String DNI_Alumno_Listar = "";
    String DNI_Coordinador = "";
    String DNI_Alumno = "";
    String mensaje_error = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CoordinadorDAO coordinadorDAO = new CoordinadorDAO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        Asignatura_OrigenDAO asignatura_origenDAO = new Asignatura_OrigenDAO();
        Asignatura_DestinoDAO asignatura_destinoDAO = new Asignatura_DestinoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        GradoDAO gradoDAO = new GradoDAO();
        RelacionAsignaturasDAO relacionAsignaturasDAO = new RelacionAsignaturasDAO();
        EstanciaDAO estanciaDAO = new EstanciaDAO();
        ConvalidacionDAO convalidacionDAO = new ConvalidacionDAO();
        Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
        muchasAsignaturas_muchos_AlumnosDAO mamaDAO = new muchasAsignaturas_muchos_AlumnosDAO();
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
            if (coordinadorDAO.obtenerPassword(usuario) == null ? password == null : coordinadorDAO.obtenerPassword(usuario).equals(password)) {
                DNI_Coordinador = coordinadorDAO.obtenerDNI(usuario);
                System.out.println("hola2");
                List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Coordinador);
                System.out.println(alumnos.toString());
                request.setAttribute("listaAlumnos", alumnos);
                //String DNI_Profesor = profesorDAO.oalumnosbtenerDNI(usuario);
                //List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Profesor);
                //request.setAttribute("listaAlumnos", alumnos);

                dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

            } else if (alumnoDAO.obtenerPassword(usuario) == null ? password == null : alumnoDAO.obtenerPassword(usuario).equals(password)) {
                DNI_Alumno = alumnoDAO.obtenerDNI(usuario);
                //System.out.println(DNI_Alumno);
                request.setAttribute("DNI_A", DNI_Alumno);
                dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");
            } else {
                String mensaje_error = "error";
                request.setAttribute("error", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/login.jsp");
            }

            //String usuario = request.getParameter("usuario");
            //request.setAttribute("usuario", usuario);
        } else if ("listarAlumnos".equals(accion)) {

            if (!request.getParameter("listaAlumnos").equals("Escoge un alumno")) {
                DNI_Alumno_Listar = request.getParameter("listaAlumnos");
            }

            System.out.println("DNI:" + DNI_Alumno_Listar);
            List<RelacionAsignaturas> listaRA = relacionAsignaturasDAO.listarConvalidaciones(DNI_Alumno_Listar);
            System.out.println("Lista: " + listaRA.toString());
            /*for (int i = 0; i < listaAsignaturas_origen.size(); i++) {
                System.out.println(listaAsignaturas_origen.get(i).getNombre());
            }*/
            //List<Asignatura_Destino> listaAsignaturas_destino = asignatura_destinoDAO.listarAsignaturas(DNI_Alumno_Listar);

            /*for (int i = 0; i < listaAsignaturas_destino.size(); i++) {
                System.out.println(listaAsignaturas_destino.get(i).getNombre());
            }*/
            dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");
            request.setAttribute("listaRA", listaRA);
            //request.setAttribute("listaAsignaturasDestino", listaAsignaturas_destino);
            //System.out.println("fdsf" + usuario);
            String DNI_Profesor = coordinadorDAO.obtenerDNI(usuario);
            //System.out.println("dsf" + DNI_Profesor);
            List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Profesor);
            request.setAttribute("listaAlumnos", alumnos);
            String estado = request.getParameter("CambiarEstado");
            //System.out.println(estado);
            String codigoAsignaturaModificar = request.getParameter("listaAsignaturasModificar");
            //String codigoAsignaturaRechazar = request.getParameter("listaAsignaturasRechazar");

            String cambioEstado = request.getParameter("modificarEstado");
            String sumaCreditos = String.valueOf(asignatura_origenDAO.sumaCreditos(DNI_Alumno_Listar));
            String nombreAlumno = alumnoDAO.obtenerNombre(DNI_Alumno_Listar);
            String apellidosAlumno = alumnoDAO.obtenerApellidos(DNI_Alumno_Listar);
            System.out.println("adfjosd: " + nombreAlumno);
            System.out.println("suma: " + sumaCreditos);
            
            request.setAttribute("sumaCreditos", sumaCreditos);
            request.setAttribute("nombreAlumno", nombreAlumno);
            request.setAttribute("apellidosAlumno", apellidosAlumno);
            //System.out.println("codigo:" + codigoAsignaturaModificar);
            //System.out.println(alumnoDAO.listarCodigosAsignaturasAlumno(DNI_Alumno_Listar));
            //System.out.println("buenassssssss");
            //System.out.println("suma"+asignatura_origenDAO.sumaCreditos(DNI_Alumno_Listar));
            //List<String> listaCodigosAsignaturasAlumno = alumnoDAO.listarCodigosAsignaturasAlumno(DNI_Alumno_Listar);
            if (!codigoAsignaturaModificar.equals("Escoge una asignatura")) {
                if (cambioEstado.equals("Aceptar")) {
                    convalidacionDAO.cambiarEstado("Aceptada", codigoAsignaturaModificar);
                } else if (cambioEstado.equals("Rechazar")) {
                    convalidacionDAO.cambiarEstado("Rechazada", codigoAsignaturaModificar);
                }

            }
            String comentarios = request.getParameter("Comentarios");
            convalidacionDAO.setComentarios(comentarios, codigoAsignaturaModificar);
            
        } else if ("nuevaEstancia".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaEstancia.jsp");
            List<Grado> grados = gradoDAO.listarGrados();
            List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            System.out.println(grados.toString());
            request.setAttribute("listaGrados", grados);
            request.setAttribute("listaUniversidades", universidades);

        } else if ("insertarEstanciaYAlumno".equals(accion)) {
            List<Grado> grados = gradoDAO.listarGrados();
            List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            System.out.println(grados.toString());
            request.setAttribute("listaGrados", grados);
            request.setAttribute("listaUniversidades", universidades);
            String password = request.getParameter("Password");
            String nombre = request.getParameter("Nombre");
            String apellidos = request.getParameter("Apellidos");
            String nombre_usuario = request.getParameter("Nombre_usuario");
            String DNI_Alumno_Insertar = request.getParameter("DNI_Alumno");
            String grado = request.getParameter("Grado");
            String tipo = request.getParameter("Tipo");
            String curso = request.getParameter("Curso");
            String duracion = request.getParameter("Duracion");
            String universidad = request.getParameter("Universidad");
            Integer id_estancia = estanciaDAO.obtenerSiguienteEstancia();
            System.out.println("id_estancia" + id_estancia);
            //System.out.println(password + nombre + apellidos + nombre_usuario + DNI_Alumno_Insertar + DNI_Coordinador + grado + tipo + curso + duracion + universidad);

            Usuario us = new Usuario(nombre_usuario);
            usuarioDAO.insertar(us);

            Alumno alumno = new Alumno(DNI_Alumno_Insertar, password, nombre, apellidos, nombre_usuario, grado);
            alumnoDAO.insertar(alumno);

            Estancia estancia = new Estancia(id_estancia, tipo, curso, duracion, false, DNI_Alumno_Insertar, DNI_Coordinador, universidad);
            estanciaDAO.insertar(estancia);

            //System.out.println("grado"+grado+"codigo"+codigo_universidad + "id"+id_estancia);
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaEstancia.jsp");
        } else if ("listarAsignaturas".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("nuevaConvalidacion".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacion.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("buscarConvalidacion".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/buscador.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("cambiarPassword".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseña.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("cambiarPassw".equals(accion)) {
            String passA = request.getParameter("PasswA");
            String passN1 = request.getParameter("PasswN1");
            String passN2 = request.getParameter("PasswN2");
            String mensaje_error = "";

            if (alumnoDAO.obtenerPassword2(DNI_Alumno).equals(passA) && passN1.equals(passN2)) {
                alumnoDAO.cambiarContraseña(DNI_Alumno, passN1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseña.jsp");
            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseña.jsp");
            }

            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);
        } else if ("insertarConvalidacion".equals(accion)) {
            //dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacion.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String codigoO = request.getParameter("CodigoO");
            String creditosO = request.getParameter("CreditosO");
            String nombreO = request.getParameter("NombreO");
            String guiaO = request.getParameter("GuiaO");

            String codigoD1 = request.getParameter("CodigoD1");
            String creditosD1 = request.getParameter("CreditosD1");
            String nombreD1 = request.getParameter("NombreD1");
            String guiaD1 = request.getParameter("GuiaD1");

            String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String guiaD2 = request.getParameter("GuiaD2");

            //Asignatura_Origen asignaturaO = new Asignatura_Origen(Integer.parseInt(codigoO), Integer.parseInt(creditosO), nombreO, guiaO);
            //asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
            //Asignatura_Destino asignaturaD1 = new Asignatura_Destino(Integer.parseInt(codigoD1), Integer.parseInt(creditosD1), Integer.parseInt(codigoO), nombreD1, guiaD1, "Pendiente");
            //asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD1);
            if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || guiaD2.equals(""))) {
                //Asignatura_Destino asignaturaD2 = new Asignatura_Destino(Integer.parseInt(codigoD2), Integer.parseInt(creditosD2), Integer.parseInt(codigoO), nombreD2, guiaD2, "Pendiente");

                //   asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
            }

            muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);

            mamaDAO.insertarMama(mama);

            dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacion.jsp");
        } else if ("buscadorConvalidacion".equals(accion)) {
            //dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacion.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String codigoBuscador = request.getParameter("CodigoBuscador");

            System.out.println("Codigo buscador " + codigoBuscador);

            List<Asignatura_Origen> listaAsignaturas_origenBuscador = asignatura_origenDAO.listarAsignaturasBuscador(codigoBuscador);
            for (int i = 0; i < listaAsignaturas_origenBuscador.size(); i++) {
                System.out.println(listaAsignaturas_origenBuscador.get(i).getNombre());
            }

            List<Asignatura_Destino> listaAsignaturas_destinoBuscador = asignatura_destinoDAO.listarAsignaturasBuscador(Integer.parseInt(codigoBuscador));

            for (int i = 0; i < listaAsignaturas_destinoBuscador.size(); i++) {
                System.out.println(listaAsignaturas_destinoBuscador.get(i).getNombre());
            }

            request.setAttribute("listaAsignaturasOrigenBuscador", listaAsignaturas_origenBuscador);
            request.setAttribute("listaAsignaturasDestinoBuscador", listaAsignaturas_destinoBuscador);

            dispatcher = request.getRequestDispatcher("ACUERDOS/buscador.jsp");
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
