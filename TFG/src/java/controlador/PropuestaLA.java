/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import modelo.Convalidacion;
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

/**
 *
 * @author Javier
 */
@WebServlet(name = "PropuestaLA", urlPatterns = {"/PropuestaLA"})
public class PropuestaLA extends HttpServlet {

    String usuario = "";
    String DNI_Alumno_Listar = "";
    String DNI_Coordinador = "";
    String DNI_Alumno = "";
    String mensaje_error = "";
    String volverAlumnoProfesor = "";

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
            System.out.println("usuario" + usuario);
            //System.out.println(profesorDAO.obtenerPassword(usuario));
            //System.out.println(password);
            if (coordinadorDAO.obtenerPassword(usuario).equals(password) && !password.equals("")) {
                DNI_Coordinador = coordinadorDAO.obtenerDNI(usuario);//////////
                List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
                request.setAttribute("listaEstancias", estancias);
                System.out.println("hola2");
                List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
                System.out.println(alumnos.toString());
                request.setAttribute("listaAlumnos", alumnos);

                dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

            } else if (alumnoDAO.obtenerPassword(usuario).equals(password) && !password.equals("")) {
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
            String id_Estancia_Listar = "0";

            if (!request.getParameter("listaEstanciasAlumnos").equals("Escoge una estancia y alumno")) {
                id_Estancia_Listar = request.getParameter("listaEstanciasAlumnos");
                System.out.println(id_Estancia_Listar);
                DNI_Alumno_Listar = estanciaDAO.obtenerDNIAlumno(Integer.parseInt(id_Estancia_Listar));
            }

            System.out.println("DNI:" + DNI_Alumno_Listar);
            List<RelacionAsignaturas> listaRA = relacionAsignaturasDAO.listarConvalidaciones(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar));
            List<RelacionAsignaturas> listaRAPosibles = relacionAsignaturasDAO.listarConvalidacionesPosibles(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar));

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
            request.setAttribute("listaRAPosibles", listaRAPosibles);
            //request.setAttribute("listaAsignaturasDestino", listaAsignaturas_destino);
            //System.out.println("fdsf" + usuario);
            String DNI_Profesor = coordinadorDAO.obtenerDNI(usuario);
            //System.out.println("dsf" + DNI_Profesor);
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Profesor);
            request.setAttribute("listaAlumnos", alumnos);
            String estado = request.getParameter("CambiarEstado");
            //System.out.println(estado);
            String codigoAsignaturaModificar = request.getParameter("listaAsignaturasModificar");
            System.out.println("codigoooooo:" + codigoAsignaturaModificar);
            String codigoAsignaturaCancelar = request.getParameter("listaAsignaturasCancelar");
            //String codigoAsignaturaRechazar = request.getParameter("listaAsignaturasRechazar");

            String cambioEstadoModificar = request.getParameter("modificarEstado");
            String sumaCreditosOrigen = String.valueOf(asignatura_origenDAO.sumaCreditosOrigen(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar)));
            String sumaCreditosDestino = String.valueOf(asignatura_origenDAO.sumaCreditosDestino(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar)));

            String nombreAlumno = alumnoDAO.obtenerNombre(DNI_Alumno_Listar);
            String apellidosAlumno = alumnoDAO.obtenerApellidos(DNI_Alumno_Listar);
            String codigoGrado = gradoDAO.gradoAlumno(DNI_Alumno_Listar).getCodigo();
            String nombreGrado = gradoDAO.gradoAlumno(DNI_Alumno_Listar).getNombre();
            String facultad = gradoDAO.gradoAlumno(DNI_Alumno_Listar).getFacultad();
            System.out.println("adfjosd: " + nombreAlumno);
            System.out.println("suma: " + sumaCreditosOrigen);

            request.setAttribute("sumaCreditosOrigen", sumaCreditosOrigen);
            request.setAttribute("sumaCreditosDestino", sumaCreditosDestino);
            request.setAttribute("nombreAlumno", nombreAlumno);
            request.setAttribute("apellidosAlumno", apellidosAlumno);
            request.setAttribute("codigoGrado", codigoGrado);
            request.setAttribute("nombreGrado", nombreGrado);
            request.setAttribute("facultad", facultad);
            //System.out.println("codigo:" + codigoAsignaturaModificar);
            //System.out.println(alumnoDAO.listarCodigosAsignaturasAlumno(DNI_Alumno_Listar));
            //System.out.println("buenassssssss");
            //System.out.println("suma"+asignatura_origenDAO.sumaCreditos(DNI_Alumno_Listar));
            //List<String> listaCodigosAsignaturasAlumno = alumnoDAO.listarCodigosAsignaturasAlumno(DNI_Alumno_Listar);
            if (!codigoAsignaturaModificar.equals("Escoge una asignatura")) {
                if (cambioEstadoModificar.equals("ACEPTAR")) {
                    System.out.println("sdfssfg");
                    convalidacionDAO.cambiarEstado("ACEPTADA", codigoAsignaturaModificar);
                } else if (cambioEstadoModificar.equals("RECHAZAR")) {
                    convalidacionDAO.cambiarEstado("RECHAZADA", codigoAsignaturaModificar);
                } else {
                    String mensaje_error = "error";
                    request.setAttribute("error", mensaje_error);
                }

            }
            if (!codigoAsignaturaCancelar.equals("Escoge una asignatura")) {

                convalidacionDAO.cambiarEstado("CANCELADA", codigoAsignaturaCancelar);

            } else {
                String mensaje_error = "error";
                request.setAttribute("error", mensaje_error);
            }
            String comentariosModificada = request.getParameter("ComentariosModificada");
            String comentariosCancelada = request.getParameter("ComentariosCancelada");
            convalidacionDAO.setComentarios(comentariosModificada, codigoAsignaturaModificar);
            convalidacionDAO.setComentarios(comentariosCancelada, codigoAsignaturaCancelar);

        } else if ("nuevoAlumno".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoAlumno.jsp");
            List<Grado> grados = gradoDAO.listarGrados();
            //List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            System.out.println(grados.toString());
            request.setAttribute("listaGrados", grados);
            //request.setAttribute("listaUniversidades", universidades);

        } else if ("nuevoProfesor".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoProfesor.jsp");
            /*List<Grado> grados = gradoDAO.listarGrados();
            //List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            System.out.println(grados.toString());
            request.setAttribute("listaGrados", grados);*/
            //request.setAttribute("listaUniversidades", universidades);

        } else if ("nuevaUniversidad".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaUniversidad.jsp");

        } else if ("renunciaAlumno".equals(accion)) {
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            System.out.println("hola2");
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            System.out.println(alumnos.toString());
            request.setAttribute("listaAlumnos", alumnos);
            dispatcher = request.getRequestDispatcher("ACUERDOS/renunciaAlumno.jsp");

        } else if ("cerrarEstancia".equals(accion)) {
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            System.out.println("hola2");
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            System.out.println(alumnos.toString());
            request.setAttribute("listaAlumnos", alumnos);
            dispatcher = request.getRequestDispatcher("ACUERDOS/cerrarEstancia.jsp");

        } else if ("nuevoGrado".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoGrado.jsp");

        } else if ("nuevaEstancia".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaEstancia.jsp");
            //List<Grado> grados = gradoDAO.listarGrados();
            List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            List<Alumno> listaAlumnosEstancia = alumnoDAO.listarAlumnos();
            //System.out.println(grados.toString());
            //request.setAttribute("listaGrados", grados);
            request.setAttribute("listaUniversidades", universidades);
            request.setAttribute("listaAlumnosEstancia", listaAlumnosEstancia);

        } else if ("insertarAlumno".equals(accion)) {
            List<Grado> grados = gradoDAO.listarGrados();
            //List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            System.out.println(grados.toString());
            request.setAttribute("listaGrados", grados);
            //request.setAttribute("listaUniversidades", universidades);
            String password = request.getParameter("Password");
            String nombre = request.getParameter("Nombre");
            String apellidos = request.getParameter("Apellidos");
            String nombre_usuario = request.getParameter("Nombre_usuario");
            String DNI_Alumno_Insertar = request.getParameter("DNI_Alumno");
            String grado = request.getParameter("Grado");
            //String tipo = request.getParameter("Tipo");
            //String curso = request.getParameter("Curso");
            //String duracion = request.getParameter("Duracion");
            //String universidad = request.getParameter("Universidad");
            //Integer id_estancia = estanciaDAO.obtenerSiguienteEstancia();
            //System.out.println("id_estancia" + id_estancia);
            //System.out.println(password + nombre + apellidos + nombre_usuario + DNI_Alumno_Insertar + DNI_Coordinador + grado + tipo + curso + duracion + universidad);

            if (!grado.equals("Escoge un grado") && !nombre.equals("") && !apellidos.equals("") && !password.equals("") && !nombre_usuario.equals("") && !DNI_Alumno_Insertar.equals("")) {
                Usuario us = new Usuario(nombre_usuario);
                usuarioDAO.insertar(us);

                Alumno alumno = new Alumno(DNI_Alumno_Insertar, nombre, apellidos, password, nombre_usuario, grado);
                alumnoDAO.insertar(alumno);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            //Estancia estancia = new Estancia(id_estancia, tipo, curso, duracion, false, DNI_Alumno_Insertar, DNI_Coordinador, universidad);
            //estanciaDAO.insertar(estancia);
            //System.out.println("grado"+grado+"codigo"+codigo_universidad + "id"+id_estancia);
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoAlumno.jsp");
        } else if ("insertarProfesor".equals(accion)) {

            //request.setAttribute("listaUniversidades", universidades);
            String password = request.getParameter("Password");
            String nombre = request.getParameter("Nombre");
            String apellidos = request.getParameter("Apellidos");
            String nombre_usuario = request.getParameter("Nombre_usuario");
            String DNI_Coordinador_Insertar = request.getParameter("DNI_Coordinador");
            String departamento = request.getParameter("Departamento");
            //String tipo = request.getParameter("Tipo");
            //String curso = request.getParameter("Curso");
            //String duracion = request.getParameter("Duracion");
            //String universidad = request.getParameter("Universidad");
            //Integer id_estancia = estanciaDAO.obtenerSiguienteEstancia();
            //System.out.println("id_estancia" + id_estancia);
            //System.out.println(password + nombre + apellidos + nombre_usuario + DNI_Alumno_Insertar + DNI_Coordinador + grado + tipo + curso + duracion + universidad);

            if (!departamento.equals("") && !nombre.equals("") && !apellidos.equals("") && !password.equals("") && !nombre_usuario.equals("") && !DNI_Coordinador_Insertar.equals("")) {
                Usuario us = new Usuario(nombre_usuario);
                usuarioDAO.insertar(us);

                Coordinador coordinador = new Coordinador(DNI_Coordinador_Insertar, password, nombre, apellidos, nombre_usuario, departamento);
                coordinadorDAO.insertar(coordinador);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            //Estancia estancia = new Estancia(id_estancia, tipo, curso, duracion, false, DNI_Alumno_Insertar, DNI_Coordinador, universidad);
            //estanciaDAO.insertar(estancia);
            //System.out.println("grado"+grado+"codigo"+codigo_universidad + "id"+id_estancia);
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoProfesor.jsp");
        } else if ("insertarEstancia".equals(accion)) {
            //List<Grado> grados = gradoDAO.listarGrados();
            List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            //System.out.println(grados.toString());
            //request.setAttribute("listaGrados", grados);
            request.setAttribute("listaUniversidades", universidades);
            //String password = request.getParameter("Password");
            //String nombre = request.getParameter("Nombre");
            //String apellidos = request.getParameter("Apellidos");
            //String nombre_usuario = request.getParameter("Nombre_usuario");
            //String DNI_Alumno_Insertar = request.getParameter("DNI_Alumno");
            //String grado = request.getParameter("Grado");
            String tipo = request.getParameter("Tipo");
            String curso = request.getParameter("Curso");
            String duracion = request.getParameter("Duracion");
            String universidad = request.getParameter("Universidad");
            Integer id_estancia = estanciaDAO.obtenerSiguienteEstancia();
            String DNI_Alumno_Insertar_Estancia = request.getParameter("listaAlumnosEstancia");

            //CAMBIAR EN SQL QUE DNI_ALUMNO Y DNI_COORDINADOR NO SEAN CLAVES EN ESTANCIA
            List<Alumno> listaAlumnosEstancia = alumnoDAO.listarAlumnos();
            request.setAttribute("listaAlumnosEstancia", listaAlumnosEstancia);
            System.out.println("id_estancia" + id_estancia);

            //System.out.println(password + nombre + apellidos + nombre_usuario + DNI_Alumno_Insertar + DNI_Coordinador + grado + tipo + curso + duracion + universidad);
            //Usuario us = new Usuario(nombre_usuario);
            //usuarioDAO.insertar(us);
            //Alumno alumno = new Alumno(DNI_Alumno_Insertar, password, nombre, apellidos, nombre_usuario, grado);
            //alumnoDAO.insertar(alumno);
            if (!DNI_Alumno_Insertar_Estancia.equals("Escoge un alumno") && !tipo.equals("Escoge un tipo de estancia")
                    && !duracion.equals("Escoge una duracion") && !universidad.equals("Escoge una universidad") && !curso.equals("")) {
                Estancia estancia = new Estancia(id_estancia, tipo, curso, duracion, false, false, universidad, DNI_Coordinador, DNI_Alumno_Insertar_Estancia);
                estanciaDAO.insertar(estancia);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            //System.out.println("grado"+grado+"codigo"+codigo_universidad + "id"+id_estancia);
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaEstancia.jsp");
        } else if ("listarAsignaturas".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("nuevasAsignaturasOrigenAlumno".equals(accion)) {
            System.out.println(volverAlumnoProfesor);
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenAlumno.jsp");

            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);
        } else if ("nuevasAsignaturasDestinoAlumno".equals(accion)) {
            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoAlumno.jsp");

            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);
        } else if ("nuevasAsignaturasOrigenProfesor".equals(accion)) {
            System.out.println(volverAlumnoProfesor);
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenProfesor.jsp");

            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);
        } else if ("nuevasAsignaturasDestinoProfesor".equals(accion)) {
            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoProfesor.jsp");

            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);
        } else if ("nuevaConvalidacion".equals(accion)) {
            List<Estancia> listaEstancias = estanciaDAO.obtenerEstanciaYUniversidad(DNI_Alumno);
            List<Asignatura_Origen> listaAsignaturasOrigen = asignatura_origenDAO.listarAsignaturas();
            List<Asignatura_Destino> listaAsignaturasDestino = asignatura_destinoDAO.listarAsignaturas(DNI_Alumno);
            request.setAttribute("listaAsignaturasDestino", listaAsignaturasDestino);
            request.setAttribute("listaAsignaturasOrigen", listaAsignaturasOrigen);
            System.out.println("GOLA" + DNI_Alumno);
            request.setAttribute("listaEstancias", listaEstancias);

            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaConvalidacion.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("verConvalidacionesActuales".equals(accion)) {
            List<Estancia> listaEstancias = estanciaDAO.obtenerEstanciaYUniversidad(DNI_Alumno);
            request.setAttribute("listaEstancias", listaEstancias);

            dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacionesActuales.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("buscarConvalidacion".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/buscador.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("cambiarPasswordAlumno".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaAlumno.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("cambiarPasswordProfesor".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaProfesor.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("cambiarPasswAlumno".equals(accion)) {
            String passA = request.getParameter("PasswA");
            String passN1 = request.getParameter("PasswN1");
            String passN2 = request.getParameter("PasswN2");
            String mensaje_error = "";

            if (alumnoDAO.obtenerPassword2(DNI_Alumno).equals(passA) && passN1.equals(passN2) && !passN1.equals("")) {
                alumnoDAO.cambiarContraseña(DNI_Alumno, passN1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaAlumno.jsp");
            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaAlumno.jsp");
            }

        } else if ("cambiarPasswProfesor".equals(accion)) {
            String passA = request.getParameter("PasswA");
            String passN1 = request.getParameter("PasswN1");
            String passN2 = request.getParameter("PasswN2");
            String mensaje_error = "";

            if (coordinadorDAO.obtenerPassword2(DNI_Coordinador).equals(passA) && passN1.equals(passN2) && !passN1.equals("")) {
                coordinadorDAO.cambiarContraseña(DNI_Coordinador, passN1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaProfesor.jsp");
            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaProfesor.jsp");
            }

        } else if ("listarAlumnosRenuncia".equals(accion)) {
            String id_Estancia = "0";
            System.out.println("entro");

            if (!request.getParameter("listaEstanciasAlumnosRenuncia").equals("Escoge una estancia y alumno")) {
                System.out.println("entro2");
                id_Estancia = request.getParameter("listaEstanciasAlumnosRenuncia");
                System.out.println(id_Estancia);
                DNI_Alumno_Listar = estanciaDAO.obtenerDNIAlumno(Integer.parseInt(id_Estancia));
            }

            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            System.out.println("hola2");
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            System.out.println(alumnos.toString());
            request.setAttribute("listaAlumnos", alumnos);

            estanciaDAO.cambiarRenuncia(Integer.parseInt(id_Estancia));

            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);
            dispatcher = request.getRequestDispatcher("ACUERDOS/renunciaAlumno.jsp");
        } else if ("listarAlumnosCerrar".equals(accion)) {
            String id_Estancia = "0";
            System.out.println("entro");

            if (!request.getParameter("listaEstanciasAlumnosCerrar").equals("Escoge una estancia y alumno")) {
                System.out.println("entro2");
                id_Estancia = request.getParameter("listaEstanciasAlumnosCerrar");
                System.out.println(id_Estancia);
                DNI_Alumno_Listar = estanciaDAO.obtenerDNIAlumno(Integer.parseInt(id_Estancia));
            }

            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            System.out.println("hola2");
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            System.out.println(alumnos.toString());
            request.setAttribute("listaAlumnos", alumnos);

            estanciaDAO.cambiarCierre(Integer.parseInt(id_Estancia));

            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);
            dispatcher = request.getRequestDispatcher("ACUERDOS/cerrarEstancia.jsp");
        } else if ("insertarAsignaturasOrigenAlumno".equals(accion)) {
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String codigoO = request.getParameter("CodigoO");
            String creditosO = request.getParameter("CreditosO");
            String nombreO = request.getParameter("NombreO");
            String informacionO = request.getParameter("InformacionO");
            String tipoO = request.getParameter("TipoO");

            /*String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String informacionD2 = request.getParameter("InformacionD2");*/
            //String codigo_universidad_destino = estanciaDAO.obtenerCodigoUniversidadDestino(DNI_Alumno);
            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            System.out.println("dni: " + DNI_Alumno);
            //System.out.println("codigo:" + codigo_universidad_destino);
            //Habra que modificarlo para que el alumno elija la estancia a la que quiere introducir la asignatura por si cambia de universidad

            if (!tipoO.equals("Escoge un tipo") && !codigoO.equals("") && !creditosO.equals("") && !informacionO.equals("") && !nombreO.equals("")) {
                Asignatura_Origen asignaturaO = new Asignatura_Origen(codigoO, Integer.parseInt(creditosO), nombreO, informacionO, tipoO);
                asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            //Asignatura_Origen asignaturaO = new Asignatura_Origen(Integer.parseInt(codigoO), Integer.parseInt(creditosO), nombreO, guiaO);
            //asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
            //Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();
            //Convalidacion c1 = new Convalidacion(id_convalidacion1, "Pendiente", "", date1, codigoD1, codigoO, id_estancia);
            //convalidacionDAO.insertarConvalidacion(c1);

            /* if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || informacionD2.equals(""))) {
                Asignatura_Destino asignaturaD2 = new Asignatura_Destino(codigoD2, Integer.parseInt(creditosD2), nombreD2, informacionD2, codigo_universidad_destino);

                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
                Integer id_convalidacion2 = convalidacionDAO.obtenerSiguienteConvalidacion();

                Convalidacion c2 = new Convalidacion(id_convalidacion2, "Pendiente", "", date1, codigoD2, codigoO, id_estancia);

                convalidacionDAO.insertarConvalidacion(c2);
            }*/
            //muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);
            //mamaDAO.insertarMama(mama);
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenAlumno.jsp");
        } else if ("insertarAsignaturasDestinoAlumno".equals(accion)) {
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            String codigoD = request.getParameter("CodigoD");
            String creditosD = request.getParameter("CreditosD");
            String nombreD = request.getParameter("NombreD");
            String informacionD = request.getParameter("InformacionD");
            String codigo_universidad_destino = request.getParameter("listaUniversidadesDsetino");

            /*String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String informacionD2 = request.getParameter("InformacionD2");*/
            //String codigo_universidad_destino = estanciaDAO.obtenerCodigoUniversidadDestino(DNI_Alumno);
            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            System.out.println("dni: " + DNI_Alumno);
            //System.out.println("codigo:" + codigo_universidad_destino);
            //Habra que modificarlo para que el alumno elija la estancia a la que quiere introducir la asignatura por si cambia de universidad

            //Asignatura_Origen asignaturaO = new Asignatura_Origen(Integer.parseInt(codigoO), Integer.parseInt(creditosO), nombreO, guiaO);
            //asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
            if (!codigo_universidad_destino.equals("Escoge una universidad") && !codigoD.equals("") && !creditosD.equals("") && !informacionD.equals("") && !nombreD.equals("")) {
                Asignatura_Destino asignaturaD1 = new Asignatura_Destino(codigoD, Integer.parseInt(creditosD), nombreD, informacionD, codigo_universidad_destino);
                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            //Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();
            //Convalidacion c1 = new Convalidacion(id_convalidacion1, "Pendiente", "", date1, codigoD1, codigoO, id_estancia);
            //convalidacionDAO.insertarConvalidacion(c1);

            /* if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || informacionD2.equals(""))) {
                Asignatura_Destino asignaturaD2 = new Asignatura_Destino(codigoD2, Integer.parseInt(creditosD2), nombreD2, informacionD2, codigo_universidad_destino);

                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
                Integer id_convalidacion2 = convalidacionDAO.obtenerSiguienteConvalidacion();

                Convalidacion c2 = new Convalidacion(id_convalidacion2, "Pendiente", "", date1, codigoD2, codigoO, id_estancia);

                convalidacionDAO.insertarConvalidacion(c2);
            }*/
            //muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);
            //mamaDAO.insertarMama(mama);
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoAlumno.jsp");
        } else if ("insertarAsignaturasOrigenProfesor".equals(accion)) {
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String codigoO = request.getParameter("CodigoO");
            String creditosO = request.getParameter("CreditosO");
            String nombreO = request.getParameter("NombreO");
            String informacionO = request.getParameter("InformacionO");
            String tipoO = request.getParameter("TipoO");

            /*String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String informacionD2 = request.getParameter("InformacionD2");*/
            //String codigo_universidad_destino = estanciaDAO.obtenerCodigoUniversidadDestino(DNI_Alumno);
            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            System.out.println("dni: " + DNI_Alumno);
            //System.out.println("codigo:" + codigo_universidad_destino);
            //Habra que modificarlo para que el alumno elija la estancia a la que quiere introducir la asignatura por si cambia de universidad

            if (!tipoO.equals("Escoge un tipo") && !codigoO.equals("") && !creditosO.equals("") && !informacionO.equals("") && !nombreO.equals("")) {
                Asignatura_Origen asignaturaO = new Asignatura_Origen(codigoO, Integer.parseInt(creditosO), nombreO, informacionO, tipoO);
                asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            //Asignatura_Origen asignaturaO = new Asignatura_Origen(Integer.parseInt(codigoO), Integer.parseInt(creditosO), nombreO, guiaO);
            //asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
            //Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();
            //Convalidacion c1 = new Convalidacion(id_convalidacion1, "Pendiente", "", date1, codigoD1, codigoO, id_estancia);
            //convalidacionDAO.insertarConvalidacion(c1);

            /* if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || informacionD2.equals(""))) {
                Asignatura_Destino asignaturaD2 = new Asignatura_Destino(codigoD2, Integer.parseInt(creditosD2), nombreD2, informacionD2, codigo_universidad_destino);

                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
                Integer id_convalidacion2 = convalidacionDAO.obtenerSiguienteConvalidacion();

                Convalidacion c2 = new Convalidacion(id_convalidacion2, "Pendiente", "", date1, codigoD2, codigoO, id_estancia);

                convalidacionDAO.insertarConvalidacion(c2);
            }*/
            //muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);
            //mamaDAO.insertarMama(mama);
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenProfesor.jsp");
        } else if ("insertarAsignaturasDestinoProfesor".equals(accion)) {
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            String codigoD = request.getParameter("CodigoD");
            String creditosD = request.getParameter("CreditosD");
            String nombreD = request.getParameter("NombreD");
            String informacionD = request.getParameter("InformacionD");
            String codigo_universidad_destino = request.getParameter("listaUniversidadesDsetino");

            /*String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String informacionD2 = request.getParameter("InformacionD2");*/
            //String codigo_universidad_destino = estanciaDAO.obtenerCodigoUniversidadDestino(DNI_Alumno);
            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            System.out.println("dni: " + DNI_Alumno);
            //System.out.println("codigo:" + codigo_universidad_destino);
            //Habra que modificarlo para que el alumno elija la estancia a la que quiere introducir la asignatura por si cambia de universidad

            //Asignatura_Origen asignaturaO = new Asignatura_Origen(Integer.parseInt(codigoO), Integer.parseInt(creditosO), nombreO, guiaO);
            //asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
            if (!codigo_universidad_destino.equals("Escoge una universidad") && !codigoD.equals("") && !creditosD.equals("") && !informacionD.equals("") && !nombreD.equals("")) {
                Asignatura_Destino asignaturaD1 = new Asignatura_Destino(codigoD, Integer.parseInt(creditosD), nombreD, informacionD, codigo_universidad_destino);
                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            //Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();
            //Convalidacion c1 = new Convalidacion(id_convalidacion1, "Pendiente", "", date1, codigoD1, codigoO, id_estancia);
            //convalidacionDAO.insertarConvalidacion(c1);

            /* if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || informacionD2.equals(""))) {
                Asignatura_Destino asignaturaD2 = new Asignatura_Destino(codigoD2, Integer.parseInt(creditosD2), nombreD2, informacionD2, codigo_universidad_destino);

                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
                Integer id_convalidacion2 = convalidacionDAO.obtenerSiguienteConvalidacion();

                Convalidacion c2 = new Convalidacion(id_convalidacion2, "Pendiente", "", date1, codigoD2, codigoO, id_estancia);

                convalidacionDAO.insertarConvalidacion(c2);
            }*/
            //muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);
            //mamaDAO.insertarMama(mama);
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoProfesor.jsp");
        } else if ("insertarConvalidacion".equals(accion)) {
            System.out.println("entrolndjksdfk");
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            List<Estancia> listaEstancias = estanciaDAO.obtenerEstanciaYUniversidad(DNI_Alumno);
            List<Asignatura_Origen> listaAsignaturasOrigen = asignatura_origenDAO.listarAsignaturas();
            List<Asignatura_Destino> listaAsignaturasDestino = asignatura_destinoDAO.listarAsignaturas(DNI_Alumno);
            request.setAttribute("listaAsignaturasDestino", listaAsignaturasDestino);
            request.setAttribute("listaAsignaturasOrigen", listaAsignaturasOrigen);
            System.out.println("GOLA" + DNI_Alumno);
            request.setAttribute("listaEstancias", listaEstancias);
            String estancia = request.getParameter("listaEstancias");
            String asignaturaOrigen = request.getParameter("listaOrigen");
            String asignaturaDestino = request.getParameter("listaDestino");

            Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();

            if (!estancia.equals("Escoge la estancia donde se va a realizar la convalidacion") && !asignaturaOrigen.equals("Escoge asignatura origen")
                    && !asignaturaDestino.equals("Escoge asignatura destino")) {
                Convalidacion c1 = new Convalidacion(id_convalidacion1, "PENDIENTE", "", asignaturaDestino, asignaturaOrigen, Integer.parseInt(estancia));
                convalidacionDAO.insertarConvalidacion(c1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            System.out.println("ede" + estancia);

            /*String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String informacionD2 = request.getParameter("InformacionD2");*/
            //String codigo_universidad_destino = estanciaDAO.obtenerCodigoUniversidadDestino(DNI_Alumno);
            //Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            //System.out.println("dni: " + DNI_Alumno);
            //System.out.println("codigo:" + codigo_universidad_destino);
            //Habra que modificarlo para que el alumno elija la estancia a la que quiere introducir la asignatura por si cambia de universidad
            //Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();
            //Convalidacion c1 = new Convalidacion(id_convalidacion1, "Pendiente", "", date1, codigoD1, codigoO, id_estancia);
            //convalidacionDAO.insertarConvalidacion(c1);

            /* if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || informacionD2.equals(""))) {
                Asignatura_Destino asignaturaD2 = new Asignatura_Destino(codigoD2, Integer.parseInt(creditosD2), nombreD2, informacionD2, codigo_universidad_destino);

                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
                Integer id_convalidacion2 = convalidacionDAO.obtenerSiguienteConvalidacion();

                Convalidacion c2 = new Convalidacion(id_convalidacion2, "Pendiente", "", date1, codigoD2, codigoO, id_estancia);

                convalidacionDAO.insertarConvalidacion(c2);
            }*/
            //muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);
            //mamaDAO.insertarMama(mama);
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaConvalidacion.jsp");
        } else if ("insertarUniversidad".equals(accion)) {
            System.out.println("entrolndjksdfk");
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String codigoU = request.getParameter("CodigoU");
            String nombreU = request.getParameter("NombreU");
            String pais = request.getParameter("Pais");
            String ciudad = request.getParameter("Ciudad");

            if (!codigoU.equals("") && !nombreU.equals("") && !pais.equals("") && !ciudad.equals("")) {
                Universidad_Destino universidad = new Universidad_Destino(codigoU, nombreU, pais, ciudad);

                universidadDAO.insertar(universidad);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            /*String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String informacionD2 = request.getParameter("InformacionD2");*/
            //String codigo_universidad_destino = estanciaDAO.obtenerCodigoUniversidadDestino(DNI_Alumno);
            //Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            //System.out.println("dni: " + DNI_Alumno);
            //System.out.println("codigo:" + codigo_universidad_destino);
            //Habra que modificarlo para que el alumno elija la estancia a la que quiere introducir la asignatura por si cambia de universidad
            //Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();
            //Convalidacion c1 = new Convalidacion(id_convalidacion1, "Pendiente", "", date1, codigoD1, codigoO, id_estancia);
            //convalidacionDAO.insertarConvalidacion(c1);

            /* if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || informacionD2.equals(""))) {
                Asignatura_Destino asignaturaD2 = new Asignatura_Destino(codigoD2, Integer.parseInt(creditosD2), nombreD2, informacionD2, codigo_universidad_destino);

                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
                Integer id_convalidacion2 = convalidacionDAO.obtenerSiguienteConvalidacion();

                Convalidacion c2 = new Convalidacion(id_convalidacion2, "Pendiente", "", date1, codigoD2, codigoO, id_estancia);

                convalidacionDAO.insertarConvalidacion(c2);
            }*/
            //muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);
            //mamaDAO.insertarMama(mama);
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaUniversidad.jsp");
        } else if ("insertarGrado".equals(accion)) {
            System.out.println("entrolndjksdfk");
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String codigoG = request.getParameter("CodigoG");
            String nombreG = request.getParameter("NombreG");
            String facultad = request.getParameter("FacultadG");

            if (!codigoG.equals("") && !nombreG.equals("") && !facultad.equals("")) {
                Grado grado = new Grado(codigoG, nombreG, facultad);
                gradoDAO.insertar(grado);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }


            /*String codigoD2 = request.getParameter("CodigoD2");
            String creditosD2 = request.getParameter("CreditosD2");
            String nombreD2 = request.getParameter("NombreD2");
            String informacionD2 = request.getParameter("InformacionD2");*/
            //String codigo_universidad_destino = estanciaDAO.obtenerCodigoUniversidadDestino(DNI_Alumno);
            //Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            //System.out.println("dni: " + DNI_Alumno);
            //System.out.println("codigo:" + codigo_universidad_destino);
            //Habra que modificarlo para que el alumno elija la estancia a la que quiere introducir la asignatura por si cambia de universidad
            //Integer id_convalidacion1 = convalidacionDAO.obtenerSiguienteConvalidacion();
            //Convalidacion c1 = new Convalidacion(id_convalidacion1, "Pendiente", "", date1, codigoD1, codigoO, id_estancia);
            //convalidacionDAO.insertarConvalidacion(c1);

            /* if (!(codigoD2.equals("") || creditosD2.equals("") || nombreD2.equals("") || informacionD2.equals(""))) {
                Asignatura_Destino asignaturaD2 = new Asignatura_Destino(codigoD2, Integer.parseInt(creditosD2), nombreD2, informacionD2, codigo_universidad_destino);

                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD2);
                Integer id_convalidacion2 = convalidacionDAO.obtenerSiguienteConvalidacion();

                Convalidacion c2 = new Convalidacion(id_convalidacion2, "Pendiente", "", date1, codigoD2, codigoO, id_estancia);

                convalidacionDAO.insertarConvalidacion(c2);
            }*/
            //muchasAsignaturas_muchos_Alumnos mama = new muchasAsignaturas_muchos_Alumnos(Integer.parseInt(codigoO), DNI_Alumno);
            //mamaDAO.insertarMama(mama);
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoGrado.jsp");
        } else if ("buscadorConvalidacion".equals(accion)) {
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String codigoBuscador = request.getParameter("CodigoBuscador");

            System.out.println("Codigo buscador " + codigoBuscador);

            List<RelacionAsignaturas> listaRelacionAsignaturasOrigenBuscador = relacionAsignaturasDAO.listarConvalidacionesBuscador(codigoBuscador);
            for (int i = 0; i < listaRelacionAsignaturasOrigenBuscador.size(); i++) {
                System.out.println(listaRelacionAsignaturasOrigenBuscador.get(i).getNombre_origen());
            }

            /*List<Asignatura_Destino> listaAsignaturas_destinoBuscador = asignatura_destinoDAO.listarAsignaturasBuscador(Integer.parseInt(codigoBuscador));

            for (int i = 0; i < listaAsignaturas_destinoBuscador.size(); i++) {
                System.out.println(listaAsignaturas_destinoBuscador.get(i).getNombre());
            }*/
            request.setAttribute("listaRelacionAsignaturasOrigenBuscador", listaRelacionAsignaturasOrigenBuscador);
            //request.setAttribute("listaAsignaturasDestinoBuscador", listaAsignaturas_destinoBuscador);

            dispatcher = request.getRequestDispatcher("ACUERDOS/buscador.jsp");
        }///////////////////// 
        else if ("convalidacionesActuales".equals(accion)) {
            System.out.println("");
            //dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturas.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

            String estancia = request.getParameter("listaEstancias");
            System.out.println("estancia:" + estancia);
            List<Estancia> listaEstancias = estanciaDAO.obtenerEstanciaYUniversidad(DNI_Alumno);
            request.setAttribute("listaEstancias", listaEstancias);

            System.out.println("dni:" + DNI_Alumno);

            if (!estancia.equals("Escoge la estancia que deseas comprobar")) {
                String sumaCreditosOrigen = String.valueOf(asignatura_origenDAO.sumaCreditosOrigen(DNI_Alumno, Integer.parseInt(estancia)));
                System.out.println("sumacreditos: " + sumaCreditosOrigen);
                String sumaCreditosDestino = String.valueOf(asignatura_origenDAO.sumaCreditosDestino(DNI_Alumno, Integer.parseInt(estancia)));
                List<RelacionAsignaturas> listaRelacionAsignaturasConvalidacionesActuales = relacionAsignaturasDAO.listarConvalidaciones(DNI_Alumno, Integer.parseInt(estancia));//////////
                request.setAttribute("sumaCreditosOrigen", sumaCreditosOrigen);
                request.setAttribute("sumaCreditosDestino", sumaCreditosDestino);
                request.setAttribute("listaRelacionAsignaturasConvalidacionesActuales", listaRelacionAsignaturasConvalidacionesActuales);
                //request.setAttribute("listaAsignaturasDestinoBuscador", listaAsignaturas_destinoBuscador);

            }
            /*for (int i = 0; i < listaRelacionAsignaturasConvalidacionesActuales.size(); i++) {
                System.out.println(listaRelacionAsignaturasConvalidacionesActuales.get(i).getNombre_origen());
            }
            List<Asignatura_Destino> listaAsignaturas_destinoBuscador = asignatura_destinoDAO.listarAsignaturasBuscador(Integer.parseInt(codigoBuscador));

            for (int i = 0; i < listaAsignaturas_destinoBuscador.size(); i++) {
                System.out.println(listaAsignaturas_destinoBuscador.get(i).getNombre());
            }*/

            dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacionesActuales.jsp");
        } else if ("volverAlumno".equals(accion)) {
            request.setAttribute("DNI_A", DNI_Alumno);
            dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("volverLogin".equals(accion)) {
            usuario = "";
            DNI_Alumno_Listar = "";
            DNI_Coordinador = "";
            DNI_Alumno = "";
            mensaje_error = "";
            dispatcher = request.getRequestDispatcher("ACUERDOS/login.jsp");
            //System.out.println("DNI"+DNI_Alumno);
            //request.setAttribute("DNI_A", DNI_Alumno);

        } else if ("volverProfesor".equals(accion)) {
            DNI_Coordinador = coordinadorDAO.obtenerDNI(usuario);//////////
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            System.out.println("hola2");
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            System.out.println(alumnos.toString());
            request.setAttribute("listaAlumnos", alumnos);
            //String DNI_Profesor = profesorDAO.oalumnosbtenerDNI(usuario);
            //List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Profesor);
            //request.setAttribute("listaAlumnos", alumnos);

            dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

        }
        try {
            //String DNI_Profesor = profesorDAO.oalumnosbtenerDNI(usuario);
            //List<Alumno> alumnos = alumnoDAO.listarAlumnos(DNI_Profesor);
            //request.setAttribute("listaAlumnos", alumnos);
            coordinadorDAO.desconectar();
            estanciaDAO.desconectar();
            alumnoDAO.desconectar();
            asignatura_origenDAO.desconectar();
            asignatura_destinoDAO.desconectar();
            usuarioDAO.desconectar();
            gradoDAO.desconectar();
            relacionAsignaturasDAO.desconectar();
            convalidacionDAO.desconectar();
            universidadDAO.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(PropuestaLA.class.getName()).log(Level.SEVERE, null, ex);
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
