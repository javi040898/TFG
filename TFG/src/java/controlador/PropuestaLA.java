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

@WebServlet(name = "PropuestaLA", urlPatterns = {"/PropuestaLA"})
public class PropuestaLA extends HttpServlet {

    //VARIABLES QUE SE MANTIENEN CADA VEZ UN USUARIO INICIA SESION, POR ESO SON GLOBALES
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

            //Accion que comprueba si el usuario y la contraseña introducidos son correctos
        } else if ("comprobarLogin".equals(accion)) {
            System.out.println("hola");

            String password = request.getParameter("password");
            usuario = request.getParameter("usuario");
            System.out.println("usuario" + usuario);
            if (coordinadorDAO.obtenerPassword(usuario).equals(password) && !password.equals("")) {
                DNI_Coordinador = coordinadorDAO.obtenerDNI(usuario);
                
                List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
                request.setAttribute("listaEstancias", estancias);

                List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
                request.setAttribute("listaAlumnos", alumnos);

                dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

            } else if (alumnoDAO.obtenerPassword(usuario).equals(password) && !password.equals("")) {
                DNI_Alumno = alumnoDAO.obtenerDNI(usuario);
                request.setAttribute("DNI_A", DNI_Alumno);
                dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");

            } else {
                mensaje_error = "error";
                request.setAttribute("error", mensaje_error);
                dispatcher = request.getRequestDispatcher("ACUERDOS/login.jsp");
            }

        } else if ("listarAlumnos".equals(accion)) {
            String id_Estancia_Listar = "0";

            if (!request.getParameter("listaEstanciasAlumnos").equals("Escoge una estancia y alumno")) {
                id_Estancia_Listar = request.getParameter("listaEstanciasAlumnos");
                DNI_Alumno_Listar = estanciaDAO.obtenerDNIAlumno(Integer.parseInt(id_Estancia_Listar));
            }
            List<RelacionAsignaturas> listaRA = relacionAsignaturasDAO.listarConvalidaciones(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar));
            List<RelacionAsignaturas> listaRAPosibles = relacionAsignaturasDAO.listarConvalidacionesPosibles(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar));

            dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");
            request.setAttribute("listaRA", listaRA);
            request.setAttribute("listaRAPosibles", listaRAPosibles);

            String DNI_Profesor = coordinadorDAO.obtenerDNI(usuario);
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);

            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Profesor);
            request.setAttribute("listaAlumnos", alumnos);

            //String estado = request.getParameter("CambiarEstado");

            //String codigoAsignaturaModificar = request.getParameter("listaAsignaturasModificar");

            //String codigoAsignaturaCancelar = request.getParameter("listaAsignaturasCancelar");

            //String cambioEstadoModificar = request.getParameter("modificarEstado");
            String sumaCreditosOrigen = String.valueOf(asignatura_origenDAO.sumaCreditosOrigen(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar)));
            String sumaCreditosDestino = String.valueOf(asignatura_origenDAO.sumaCreditosDestino(DNI_Alumno_Listar, Integer.parseInt(id_Estancia_Listar)));

            String nombreAlumno = alumnoDAO.obtenerNombre(DNI_Alumno_Listar);
            String apellidosAlumno = alumnoDAO.obtenerApellidos(DNI_Alumno_Listar);
            String codigoGrado = gradoDAO.gradoAlumno(DNI_Alumno_Listar).getCodigo();
            String nombreGrado = gradoDAO.gradoAlumno(DNI_Alumno_Listar).getNombre();
            String facultad = gradoDAO.gradoAlumno(DNI_Alumno_Listar).getFacultad();

            request.setAttribute("sumaCreditosOrigen", sumaCreditosOrigen);
            request.setAttribute("sumaCreditosDestino", sumaCreditosDestino);
            request.setAttribute("nombreAlumno", nombreAlumno);
            request.setAttribute("apellidosAlumno", apellidosAlumno);
            request.setAttribute("codigoGrado", codigoGrado);
            request.setAttribute("nombreGrado", nombreGrado);
            request.setAttribute("facultad", facultad);

        } else if ("modificarAsignatura".equals(accion)) {
            String codigoConvalidacionModificar = request.getParameter("listaAsignaturasModificar");
            String cambioEstadoModificar = request.getParameter("modificarEstado");
            System.out.println("codigo: " + codigoConvalidacionModificar);

            if (!codigoConvalidacionModificar.equals("Escoge una convalidacion")) {
                Integer codigoConvalidacionModificar2 = Integer.parseInt(codigoConvalidacionModificar);
                switch (cambioEstadoModificar) {
                    case "ACEPTAR":
                        convalidacionDAO.cambiarEstado("ACEPTADA", codigoConvalidacionModificar2);
                        break;
                    case "RECHAZAR":
                        convalidacionDAO.cambiarEstado("RECHAZADA", codigoConvalidacionModificar2);
                        break;
                    default:
                        mensaje_error = "error";
                        request.setAttribute("error", mensaje_error);
                        break;
                }
                String comentariosModificada = request.getParameter("ComentariosModificada");
                convalidacionDAO.setComentarios(comentariosModificada, codigoConvalidacionModificar2);

            }
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);

            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            request.setAttribute("listaAlumnos", alumnos);
            dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

        } else if ("cancelarAsignatura".equals(accion)) {
            String codigoConvalidacionCancelar = request.getParameter("listaAsignaturasCancelar");

            if (!codigoConvalidacionCancelar.equals("Escoge una convalidacion")) {
                Integer codigoConvalidacionCancelar2 = Integer.parseInt(codigoConvalidacionCancelar);
                convalidacionDAO.cambiarEstado("CANCELADA", codigoConvalidacionCancelar2);
                String comentariosCancelada = request.getParameter("ComentariosCancelada");
                convalidacionDAO.setComentarios(comentariosCancelada, codigoConvalidacionCancelar2);

            } else {
                mensaje_error = "error";
                request.setAttribute("error", mensaje_error);
            }
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);

            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            request.setAttribute("listaAlumnos", alumnos);
            dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

        } else if ("nuevoAlumno".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoAlumno.jsp");
            List<Grado> grados = gradoDAO.listarGrados();
            request.setAttribute("listaGrados", grados);

        } else if ("nuevoProfesor".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoProfesor.jsp");

        } else if ("nuevaUniversidad".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaUniversidad.jsp");

        } else if ("renunciaAlumno".equals(accion)) {
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            request.setAttribute("listaAlumnos", alumnos);
            dispatcher = request.getRequestDispatcher("ACUERDOS/renunciaAlumno.jsp");

        } else if ("cerrarEstancia".equals(accion)) {
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            request.setAttribute("listaAlumnos", alumnos);
            dispatcher = request.getRequestDispatcher("ACUERDOS/cerrarEstancia.jsp");

        } else if ("nuevoGrado".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoGrado.jsp");

        } else if ("nuevaEstancia".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaEstancia.jsp");
            List<Universidad_Destino> universidades = universidadDAO.listarUniversidades();
            List<Alumno> listaAlumnosEstancia = alumnoDAO.listarAlumnos();
            request.setAttribute("listaUniversidades", universidades);
            request.setAttribute("listaAlumnosEstancia", listaAlumnosEstancia);

        } else if ("insertarAlumno".equals(accion)) {
            List<Grado> grados = gradoDAO.listarGrados();
            request.setAttribute("listaGrados", grados);
            String password = request.getParameter("Password");
            String nombre = request.getParameter("Nombre");
            String apellidos = request.getParameter("Apellidos");
            String nombre_usuario = request.getParameter("Nombre_usuario");
            String DNI_Alumno_Insertar = request.getParameter("DNI_Alumno");
            String grado = request.getParameter("Grado");

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
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoAlumno.jsp");
        } else if ("insertarProfesor".equals(accion)) {

            String password = request.getParameter("Password");
            String nombre = request.getParameter("Nombre");
            String apellidos = request.getParameter("Apellidos");
            String nombre_usuario = request.getParameter("Nombre_usuario");
            String DNI_Coordinador_Insertar = request.getParameter("DNI_Coordinador");
            String departamento = request.getParameter("Departamento");

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
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaEstancia.jsp");
        } else if ("listarAsignaturas".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");

        } else if ("nuevasAsignaturasOrigenAlumno".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenAlumno.jsp");

        } else if ("nuevasAsignaturasDestinoAlumno".equals(accion)) {
            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoAlumno.jsp");

        } else if ("nuevasAsignaturasOrigenProfesor".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenProfesor.jsp");

        } else if ("nuevasAsignaturasDestinoProfesor".equals(accion)) {
            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoProfesor.jsp");

        } else if ("nuevaConvalidacion".equals(accion)) {
            List<Estancia> listaEstancias = estanciaDAO.obtenerEstanciaYUniversidad(DNI_Alumno);
            List<Asignatura_Origen> listaAsignaturasOrigen = asignatura_origenDAO.listarAsignaturas();
            List<Asignatura_Destino> listaAsignaturasDestino = asignatura_destinoDAO.listarAsignaturas(DNI_Alumno);
            request.setAttribute("listaAsignaturasDestino", listaAsignaturasDestino);
            request.setAttribute("listaAsignaturasOrigen", listaAsignaturasOrigen);
            request.setAttribute("listaEstancias", listaEstancias);

            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaConvalidacion.jsp");

        } else if ("verConvalidacionesActuales".equals(accion)) {
            List<Estancia> listaEstancias = estanciaDAO.obtenerEstanciaYUniversidad(DNI_Alumno);
            request.setAttribute("listaEstancias", listaEstancias);

            dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacionesActuales.jsp");

        } else if ("buscarConvalidacion".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/buscador.jsp");

        } else if ("cambiarPasswordAlumno".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaAlumno.jsp");

        } else if ("cambiarPasswordProfesor".equals(accion)) {
            dispatcher = request.getRequestDispatcher("ACUERDOS/cambiarContraseñaProfesor.jsp");

        } else if ("cambiarPasswAlumno".equals(accion)) {
            String passA = request.getParameter("PasswA");
            String passN1 = request.getParameter("PasswN1");
            String passN2 = request.getParameter("PasswN2");
            mensaje_error = "";

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
            mensaje_error = "";

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

            if (!request.getParameter("listaEstanciasAlumnosRenuncia").equals("Escoge una estancia y alumno")) {
                id_Estancia = request.getParameter("listaEstanciasAlumnosRenuncia");
                System.out.println(id_Estancia);
                DNI_Alumno_Listar = estanciaDAO.obtenerDNIAlumno(Integer.parseInt(id_Estancia));
            }

            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            request.setAttribute("listaAlumnos", alumnos);

            estanciaDAO.cambiarRenuncia(Integer.parseInt(id_Estancia));

            dispatcher = request.getRequestDispatcher("ACUERDOS/renunciaAlumno.jsp");
        } else if ("listarAlumnosCerrar".equals(accion)) {
            String id_Estancia = "0";

            if (!request.getParameter("listaEstanciasAlumnosCerrar").equals("Escoge una estancia y alumno")) {
                id_Estancia = request.getParameter("listaEstanciasAlumnosCerrar");
                DNI_Alumno_Listar = estanciaDAO.obtenerDNIAlumno(Integer.parseInt(id_Estancia));
            }

            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinadorNoCerradas(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            request.setAttribute("listaAlumnos", alumnos);

            estanciaDAO.cambiarCierre(Integer.parseInt(id_Estancia));

            dispatcher = request.getRequestDispatcher("ACUERDOS/cerrarEstancia.jsp");
        } else if ("insertarAsignaturasOrigenAlumno".equals(accion)) {

            String codigoO = request.getParameter("CodigoO");
            String creditosO = request.getParameter("CreditosO");
            String nombreO = request.getParameter("NombreO");
            String informacionO = request.getParameter("InformacionO");
            String tipoO = request.getParameter("TipoO");

            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);
            System.out.println("dni: " + DNI_Alumno);

            if (!tipoO.equals("Escoge un tipo") && !codigoO.equals("") && !creditosO.equals("") && !informacionO.equals("") && !nombreO.equals("")) {
                Asignatura_Origen asignaturaO = new Asignatura_Origen(codigoO, Integer.parseInt(creditosO), nombreO, informacionO, tipoO);
                asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }
            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenAlumno.jsp");
        } else if ("insertarAsignaturasDestinoAlumno".equals(accion)) {

            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            String codigoD = request.getParameter("CodigoD");
            String creditosD = request.getParameter("CreditosD");
            String nombreD = request.getParameter("NombreD");
            String informacionD = request.getParameter("InformacionD");
            String codigo_universidad_destino = request.getParameter("listaUniversidadesDsetino");

            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);

            if (!codigo_universidad_destino.equals("Escoge una universidad") && !codigoD.equals("") && !creditosD.equals("") && !informacionD.equals("") && !nombreD.equals("")) {
                Asignatura_Destino asignaturaD1 = new Asignatura_Destino(codigoD, Integer.parseInt(creditosD), nombreD, informacionD, codigo_universidad_destino);
                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoAlumno.jsp");
        } else if ("insertarAsignaturasOrigenProfesor".equals(accion)) {
            String codigoO = request.getParameter("CodigoO");
            String creditosO = request.getParameter("CreditosO");
            String nombreO = request.getParameter("NombreO");
            String informacionO = request.getParameter("InformacionO");
            String tipoO = request.getParameter("TipoO");

            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);

            if (!tipoO.equals("Escoge un tipo") && !codigoO.equals("") && !creditosO.equals("") && !informacionO.equals("") && !nombreO.equals("")) {
                Asignatura_Origen asignaturaO = new Asignatura_Origen(codigoO, Integer.parseInt(creditosO), nombreO, informacionO, tipoO);
                asignatura_origenDAO.insertarAsignaturaOrigen(asignaturaO);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasOrigenProfesor.jsp");
        } else if ("insertarAsignaturasDestinoProfesor".equals(accion)) {

            List<Universidad_Destino> listaUniversidades = universidadDAO.listarUniversidades();
            request.setAttribute("listaUniversidades", listaUniversidades);

            String codigoD = request.getParameter("CodigoD");
            String creditosD = request.getParameter("CreditosD");
            String nombreD = request.getParameter("NombreD");
            String informacionD = request.getParameter("InformacionD");
            String codigo_universidad_destino = request.getParameter("listaUniversidadesDsetino");

            Integer id_estancia = estanciaDAO.obtenerIdEstancia(DNI_Alumno);

            if (!codigo_universidad_destino.equals("Escoge una universidad") && !codigoD.equals("") && !creditosD.equals("") && !informacionD.equals("") && !nombreD.equals("")) {
                Asignatura_Destino asignaturaD1 = new Asignatura_Destino(codigoD, Integer.parseInt(creditosD), nombreD, informacionD, codigo_universidad_destino);
                asignatura_destinoDAO.insertarAsignaturaDestino(asignaturaD1);
                mensaje_error = "correcto";
                request.setAttribute("confirmacion", mensaje_error);

            } else {
                mensaje_error = "error";
                request.setAttribute("confirmacion", mensaje_error);

            }

            dispatcher = request.getRequestDispatcher("ACUERDOS/insertarAsignaturasDestinoProfesor.jsp");
        } else if ("insertarConvalidacion".equals(accion)) {
            System.out.println("entrolndjksdfk");

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

            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaConvalidacion.jsp");
        } else if ("insertarUniversidad".equals(accion)) {
            System.out.println("entrolndjksdfk");

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

            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevaUniversidad.jsp");
        } else if ("insertarGrado".equals(accion)) {

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
            dispatcher = request.getRequestDispatcher("ACUERDOS/nuevoGrado.jsp");
        } else if ("buscadorConvalidacion".equals(accion)) {

            String codigoBuscador = request.getParameter("CodigoBuscador");

            List<RelacionAsignaturas> listaRelacionAsignaturasOrigenBuscador = relacionAsignaturasDAO.listarConvalidacionesBuscador(codigoBuscador);
            for (int i = 0; i < listaRelacionAsignaturasOrigenBuscador.size(); i++) {
                System.out.println(listaRelacionAsignaturasOrigenBuscador.get(i).getNombre_origen());
            }

            request.setAttribute("listaRelacionAsignaturasOrigenBuscador", listaRelacionAsignaturasOrigenBuscador);
            dispatcher = request.getRequestDispatcher("ACUERDOS/buscador.jsp");
        } else if ("convalidacionesActuales".equals(accion)) {

            String estancia = request.getParameter("listaEstancias");
            List<Estancia> listaEstancias = estanciaDAO.obtenerEstanciaYUniversidad(DNI_Alumno);
            request.setAttribute("listaEstancias", listaEstancias);

            if (!estancia.equals("Escoge la estancia que deseas comprobar")) {
                String sumaCreditosOrigen = String.valueOf(asignatura_origenDAO.sumaCreditosOrigen(DNI_Alumno, Integer.parseInt(estancia)));
                System.out.println("sumacreditos: " + sumaCreditosOrigen);
                String sumaCreditosDestino = String.valueOf(asignatura_origenDAO.sumaCreditosDestino(DNI_Alumno, Integer.parseInt(estancia)));
                List<RelacionAsignaturas> listaRelacionAsignaturasConvalidacionesActuales = relacionAsignaturasDAO.listarConvalidaciones(DNI_Alumno, Integer.parseInt(estancia));//////////
                request.setAttribute("sumaCreditosOrigen", sumaCreditosOrigen);
                request.setAttribute("sumaCreditosDestino", sumaCreditosDestino);
                request.setAttribute("listaRelacionAsignaturasConvalidacionesActuales", listaRelacionAsignaturasConvalidacionesActuales);

            }

            dispatcher = request.getRequestDispatcher("ACUERDOS/convalidacionesActuales.jsp");
        } else if ("volverAlumno".equals(accion)) {
            request.setAttribute("DNI_A", DNI_Alumno);
            dispatcher = request.getRequestDispatcher("ACUERDOS/alumno.jsp");

        } else if ("volverLogin".equals(accion)) {
            usuario = "";
            DNI_Alumno_Listar = "";
            DNI_Coordinador = "";
            DNI_Alumno = "";
            mensaje_error = "";
            dispatcher = request.getRequestDispatcher("ACUERDOS/login.jsp");

        } else if ("volverProfesor".equals(accion)) {
            DNI_Coordinador = coordinadorDAO.obtenerDNI(usuario);//////////
            List<Estancia> estancias = estanciaDAO.listarEstanciasCoordinador(DNI_Coordinador);
            request.setAttribute("listaEstancias", estancias);
            System.out.println("hola2");
            List<Alumno> alumnos = alumnoDAO.listarAlumnosCoordinador(DNI_Coordinador);
            System.out.println(alumnos.toString());
            request.setAttribute("listaAlumnos", alumnos);
            dispatcher = request.getRequestDispatcher("ACUERDOS/profesor.jsp");

        }
        try {
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
