package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.EstanciaDAO;
import modelo.Universidad_DestinoDAO;
import modelo.Estancia;
import modelo.RelacionAsignaturas;
import modelo.Asignatura_Destino;
import modelo.Asignatura_Origen;
import modelo.Alumno;
import java.util.List;

public final class profesor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">      <title>PROFESOR</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #titulo1{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                background:#E3D5CD;\n");
      out.write("                margin:20px;\n");
      out.write("                padding:10px;\n");
      out.write("                top:260px;\n");
      out.write("                position:absolute;\n");
      out.write("                left:20px;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #titulo2{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:750px;\n");
      out.write("\n");
      out.write("                background:#E3D5CD;\n");
      out.write("                margin:20px;\n");
      out.write("                padding:10px;\n");
      out.write("                top:260px;\n");
      out.write("                position:absolute;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #tituloModificar{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:30px;\n");
      out.write("                margin:60px;\n");
      out.write("                top:150px;\n");
      out.write("                position:relative;\n");
      out.write("                font-size: xx-large;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #tituloCancelar{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:0px;\n");
      out.write("                margin:60px;\n");
      out.write("                top:60px;\n");
      out.write("                position:relative;\n");
      out.write("                font-size: xx-large;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #NombreAlumno{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:1370px;\n");
      out.write("\n");
      out.write("                margin:20px;\n");
      out.write("                padding:10px;\n");
      out.write("                top:0px;\n");
      out.write("                position:absolute;\n");
      out.write("                color: #050404\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #ApellidosAlumno{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:1370px;\n");
      out.write("\n");
      out.write("                margin:20px;\n");
      out.write("                padding:10px;\n");
      out.write("                top:20px;\n");
      out.write("                position:absolute;\n");
      out.write("                color: #050404\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #CodigoGrado{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:1370px;\n");
      out.write("\n");
      out.write("                margin:20px;\n");
      out.write("                padding:10px;\n");
      out.write("                top:40px;\n");
      out.write("                position:absolute;\n");
      out.write("                color: #050404\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #NombreGrado{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:1370px;\n");
      out.write("\n");
      out.write("                margin:20px;\n");
      out.write("                padding:10px;\n");
      out.write("                top:60px;\n");
      out.write("                position:absolute;\n");
      out.write("                color: #050404;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #Facultad{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:1370px;\n");
      out.write("\n");
      out.write("                margin:20px;\n");
      out.write("                padding:10px;\n");
      out.write("                top:80px;\n");
      out.write("                position:absolute;\n");
      out.write("                color: #050404;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #comentariosModificada {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:15px;\n");
      out.write("                position:relative;\n");
      out.write("                top:0px;\n");
      out.write("                left: -15px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #comentariosCancelada {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:15px;\n");
      out.write("                position:relative;\n");
      out.write("                top:0px;\n");
      out.write("                left: -15px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #label1 {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:15px;\n");
      out.write("                position:relative;\n");
      out.write("                top:42px;\n");
      out.write("                left: 925px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #form7 {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                position:relative;\n");
      out.write("                top:250px;\n");
      out.write("                right:580px;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #form11 {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                position:relative;\n");
      out.write("                top:-15px;\n");
      out.write("                right:-1196px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #form8 {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                position:relative;\n");
      out.write("                top:250px;\n");
      out.write("                right:560px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #form20{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                position:absolute;\n");
      out.write("                top:1500px;\n");
      out.write("                right:560px;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #form10 {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                padding:10px;\n");
      out.write("                position:relative;\n");
      out.write("                left:600px;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #form6 {\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                padding:10px;\n");
      out.write("                position:relative;\n");
      out.write("                top:2px;\n");
      out.write("                left: 600px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #butAceptar{\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                padding:10px;\n");
      out.write("                position:absolute;\n");
      out.write("\n");
      out.write("                display:block;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                left:1280px;\n");
      out.write("                top:20px;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #butModificar{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                position:relative;\n");
      out.write("                top:252px;\n");
      out.write("                right:565px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #butCancelar{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                position:relative;\n");
      out.write("                top:-12px;\n");
      out.write("                right:-1190px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #enlaceNuevo{\n");
      out.write("\n");
      out.write("                position:absolute;\n");
      out.write("\n");
      out.write("                display:block;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                left:350px;\n");
      out.write("                top:20px;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #table1 table {\n");
      out.write("                width: 100%;\n");
      out.write("                border: black 1px solid;\n");
      out.write("                position: relative;\n");
      out.write("                bottom: -200px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #table1 th, td {\n");
      out.write("\n");
      out.write("                text-align: left;\n");
      out.write("                vertical-align: top;\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                border: hidden;\n");
      out.write("                background:#EDE6E2;\n");
      out.write("                padding: 0.3em;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #table3 table {\n");
      out.write("                width: 100%;\n");
      out.write("                border: black 1px solid;\n");
      out.write("                position: relative;\n");
      out.write("                bottom: -195px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #table3 th, td {\n");
      out.write("\n");
      out.write("                text-align: left;\n");
      out.write("                vertical-align: top;\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                border: hidden;\n");
      out.write("                padding: 0.3em;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #table5 table {\n");
      out.write("                width: 100%;\n");
      out.write("                border: black 1px solid;\n");
      out.write("                position: relative;\n");
      out.write("                bottom: -195px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            #table5 th, td {\n");
      out.write("\n");
      out.write("                text-align: left;\n");
      out.write("                vertical-align: top;\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                border: hidden;\n");
      out.write("                padding: 0.3em;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            #volver{\n");
      out.write("                float:left;\n");
      out.write("                position:absolute;\n");
      out.write("                top:20px;\n");
      out.write("                left:20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"PropuestaLA?accion=listarAlumnos\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            <p align=\"center\"> \n");
      out.write("            <div id=\"form6\">\n");
      out.write("                <select class=\"form-control\" id=\"listaEstanciasAlumnos\" name=\"listaEstanciasAlumnos\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <option>Escoge una estancia y alumno</option>\n");
      out.write("                    ");

                        Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
                        EstanciaDAO estanciaDAO = new EstanciaDAO();
                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        List<Estancia> listaEstancias = (List<Estancia>) request.getAttribute("listaEstancias");

                        if (listaAlumnos != null)
                            if (listaEstancias != null)
                                for (Estancia estancia : listaEstancias) {
                                    String cerrada = "EN PROGRESO";
                                    for (Alumno alumno : listaAlumnos) {

                                        if (alumno.getDNI().equals(estancia.getDNI_alumno())) {
                                            if (estanciaDAO.obtenerRenuncia(estancia.getId_estancia())) {
                                                cerrada = "RENUNCIADA";
                                            } else {
                                                if (estanciaDAO.obtenerCerrada(estancia.getId_estancia())) {
                                                    cerrada = "CERRADA";
                                                }
                                            }


                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(estancia.getId_estancia());
      out.write('"');
      out.write('>');
      out.print(estancia.getTipo() + " ");
      out.print(universidadDAO.obtenerNombre(estancia.getCodigo_erasmus_Universidad_destino()));
      out.print(" ("
                            + estancia.getCurso_academico() + ") ");
      out.print(alumno.getNombre());
      out.print(" " + alumno.getApellidos());
      out.print(" (" + alumno.getDNI() + ") ");
      out.print(cerrada);
      out.write("\n");
      out.write("                    </option>\n");
      out.write("                    ");

                                    break;
                                }

                            }
                        }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
  String nombre = "";
                if (String.valueOf(request.getAttribute("nombreAlumno")) != "null") {
                    nombre = String.valueOf(request.getAttribute("nombreAlumno"));
                }

                String apellidos = "";
                if (String.valueOf(request.getAttribute("apellidosAlumno")) != "null") {
                    apellidos = String.valueOf(request.getAttribute("apellidosAlumno"));
                }
            
      out.write("    \n");
      out.write("            ");

                String codigoGrado = "";
                if (String.valueOf(request.getAttribute("codigoGrado")) != "null") {
                    codigoGrado = String.valueOf(request.getAttribute("codigoGrado"));
                }
            
      out.write("   \n");
      out.write("\n");
      out.write("            ");

                String nombreGrado = "";
                if (String.valueOf(request.getAttribute("nombreGrado")) != "null") {
                    nombreGrado = String.valueOf(request.getAttribute("nombreGrado"));
                }
            
      out.write("  \n");
      out.write("\n");
      out.write("            ");

                String facultad = "";
                if (String.valueOf(request.getAttribute("facultad")) != "null") {
                    facultad = String.valueOf(request.getAttribute("facultad"));
                }
            
      out.write(" \n");
      out.write("\n");
      out.write("            <div id=\"NombreAlumno\">Nombre: ");
      out.print(nombre);
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"ApellidosAlumno\">Apellidos: ");
      out.print(apellidos);
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"CodigoGrado\">Codigo Grado: ");
      out.print(codigoGrado);
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"NombreGrado\" color=\"#0CF\">Nombre Grado: ");
      out.print(nombreGrado);
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"Facultad\">Facultad: ");
      out.print(facultad);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"table1\">\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                    <div id=\"titulo1\"> ASIGNATURAS A RECONOCER EN LA UNIVERSIDAD DE ALCALÁ\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"titulo2\"> ASIGNATURAS CURSADAS  EN LA UNIVERSIDAD DE DESTINO\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th>Convalidacion</th>\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Nombre Asignatura</th>\n");
      out.write("                    <th>Tipo</th>\n");
      out.write("                    <th>Creditos</th>\n");
      out.write("\n");
      out.write("                    <th>Link asignatura</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Nombre Asignatura</th>\n");
      out.write("                    <th>Creditos</th>\n");
      out.write("                    <th>Link asignatura</th>\n");
      out.write("                    <th>Universidad</th>\n");
      out.write("                    <th>Fecha convalidacion</th>\n");
      out.write("                    <th>Curso academico</th>\n");
      out.write("                    <th>Estado</th>\n");
      out.write("                    <th>Comentarios</th>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                    <tbody>\n");
      out.write("\n");
      out.write("                        ");
 List<RelacionAsignaturas> listaRA = (List<RelacionAsignaturas>) request.getAttribute("listaRA");

                            if (listaRA != null)
                                for (RelacionAsignaturas ra : listaRA) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(ra.getId_convalidacion());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getCodigo_origen());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getNombre_origen());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getTipo());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getCreditos_origen());
      out.write("</td>\n");
      out.write("                            <td><a href=\"");
      out.print(ra.getInformacion_origen());
      out.write("\" target=\"_blank\" > link</a></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td>");
      out.print(ra.getCodigo_destino());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getNombre_destino());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getCreditos_destino());
      out.write("</td>\n");
      out.write("\n");
      out.write("                            <td><a href=\"");
      out.print(ra.getInformacion_destino());
      out.write("\" target=\"_blank\" > link</a></td>\n");
      out.write("                            <td>");
      out.print(ra.getNombre_universidad());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getFecha());
      out.write("</td>\n");
      out.write("\n");
      out.write("                            <td>");
      out.print(ra.getCurso());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getEstado());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getComentarios());
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                                }
                            // }

                            // }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"table3\">\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            ");

                                String sumaCreditosOrigen = "";
                                if (String.valueOf(request.getAttribute("sumaCreditosOrigen")) != "null") {
                                    sumaCreditosOrigen = String.valueOf(request.getAttribute("sumaCreditosOrigen"));
                                }
                            
      out.write(" \n");
      out.write("                            <th>Total creditos aceptados en la Universidad de Alcalá: ");
      out.print(sumaCreditosOrigen);
      out.write("</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"table5\">\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            ");

                                String sumaCreditosDestino = "";
                                if (String.valueOf(request.getAttribute("sumaCreditosDestino")) != "null") {
                                    sumaCreditosDestino = String.valueOf(request.getAttribute("sumaCreditosDestino"));
                                }
                            
      out.write(" \n");
      out.write("                            <th>Total creditos aceptados en la Universidad de Destino: ");
      out.print(sumaCreditosDestino);
      out.write("</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butAceptar\">\n");
      out.write("                <button>Aceptar</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"PropuestaLA?accion=modificarAsignatura\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"tituloModificar\">  <h1 >MODIFICAR CONVALIDACION</h1></div>\n");
      out.write("            <div id=\"form7\">\n");
      out.write("\n");
      out.write("                <select class=\"form-control\" id=\"listaAsignaturasModificar\" name=\"listaAsignaturasModificar\" action=\"modificar\" >\n");
      out.write("                    \n");
      out.write("                    <option>Escoge una convalidacion</option>\n");
      out.write("\n");
      out.write("                    ");
  List<RelacionAsignaturas> listaRAPosibles = (List<RelacionAsignaturas>) request.getAttribute("listaRAPosibles");
                        if (listaRAPosibles != null)
                            for (RelacionAsignaturas ra : listaRAPosibles) {
                                if (ra.getEstado().equals("PENDIENTE")) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(ra.getId_convalidacion());
      out.write('"');
      out.write('>');
      out.print("Convalidacion Nº " );
      out.print(ra.getId_convalidacion());
      out.write("</option>\n");
      out.write("                    ");
 }
                        }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                <div id=\"comentariosModificada\"> <label>Comentarios</label>\n");
      out.write("                    <input id=\"ComentariosModificada\" class=\"form-control\" name=\"ComentariosModificada\" type=\"textarea\" align=\"left\" size=\"50\"/></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"form8\">\n");
      out.write("\n");
      out.write("                <select class=\"form-control\" id=\"modificarEstado\" name=\"modificarEstado\">\n");
      out.write("                    <option>Escoge un estado</option>\n");
      out.write("                    <option>ACEPTAR</option>\n");
      out.write("                    <option>RECHAZAR</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butModificar\">\n");
      out.write("                <button>Modificar</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"PropuestaLA?accion=cancelarAsignatura\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            <div id=\"tituloCancelar\">  <h1 >CANCELAR CONVALIDACION</h1></div>\n");
      out.write("            <div id=\"form11\">\n");
      out.write("                <select class=\"form-control\" id=\"listaAsignaturasCancelar\" name=\"listaAsignaturasCancelar\">\n");
      out.write("                    <option>Escoge una convalidacion</option>\n");
      out.write("                    ");
 if (listaRAPosibles != null)
                            for (RelacionAsignaturas ra : listaRAPosibles) {
                                if (ra.getEstado().equals("ACEPTADA")) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(ra.getId_convalidacion());
      out.write('"');
      out.write('>');
      out.print("Convalidacion Nº " );
      out.print(ra.getId_convalidacion());
      out.write("</option>\n");
      out.write("                    ");
 }
                        }
      out.write("\n");
      out.write("\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                <div id=\"comentariosCancelada\">\n");
      out.write("                    <label>Comentarios</label>\n");
      out.write("                    <input id=\"comentariosCancelada\" class=\"form-control\" name=\"ComentariosCancelada\" type=\"textarea\" align=\"left\" size=\"40\"/></div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"butCancelar\">\n");
      out.write("                <button>Cancelar</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div id=\"form20\">  <br></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br><br><br>\n");
      out.write("        <div id=\"enlaceNuevo\">\n");
      out.write("            <a href=\"PropuestaLA?accion=nuevoAlumno\">Dar de alta a alumno</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=nuevaEstancia\">Nueva estancia de alumno</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=nuevoProfesor\">Dar de alta a profesor</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=nuevaUniversidad\">Nueva universidad de destino</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=nuevoGrado\">Nuevo grado</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=renunciaAlumno\">Renuncia alumno</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=cerrarEstancia\">Cerrar estancia</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=nuevasAsignaturasOrigenProfesor\">Nueva asignatura origen</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=nuevasAsignaturasDestinoProfesor\">Nueva asignatura destino</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"PropuestaLA?accion=cambiarPasswordProfesor\">Cambiar contraseña</a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"volver\">\n");
      out.write("            <a href=\"PropuestaLA?accion=volverLogin\">Volver</a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
