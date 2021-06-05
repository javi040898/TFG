package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>PROFESOR</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"div01\"> PROFESOR</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"ProfesorController?accion=listarAlumnos\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            <p align=\"center\"> \n");
      out.write("            <div id=\"form6\">\n");
      out.write("                <select class=\"form-control\" id=\"listaAlumnos\" name=\"listaAlumnos\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <option>Escoge un alumno</option>\n");
      out.write("                    ");


                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        if (listaAlumnos != null)
                            for (Alumno alumno : listaAlumnos) {
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(alumno.getDNI());
      out.write('"');
      out.write('>');
      out.print(alumno.getNombre());
      out.print(" " + alumno.getApellidos());
      out.print(" (" + alumno.getDNI() + " )");
      out.write("</option>\n");
      out.write("                    ");
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
      out.write("            <div id=\"butAceptar\">\n");
      out.write("                <button>Aceptar</button>\n");
      out.write("            </div>\n");
      out.write("            ");
  String nombre = "";
                if (String.valueOf(request.getAttribute("nombreAlumno")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("nombreAlumno")));
                    nombre = String.valueOf(request.getAttribute("nombreAlumno"));
                }

                String apellidos = "";
                if (String.valueOf(request.getAttribute("apellidosAlumno")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("nombreAlumno")));
                    apellidos = String.valueOf(request.getAttribute("apellidosAlumno"));
                }
            
      out.write("    \n");
      out.write("            ");

                String codigoGrado = "";
                if (String.valueOf(request.getAttribute("codigoGrado")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("codigoGrado")));
                    codigoGrado = String.valueOf(request.getAttribute("codigoGrado"));
                }
            
      out.write("   \n");
      out.write("\n");
      out.write("            ");

                String nombreGrado = "";
                if (String.valueOf(request.getAttribute("nombreGrado")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("nombreGrado")));
                    nombreGrado = String.valueOf(request.getAttribute("nombreGrado"));
                }
            
      out.write("  \n");
      out.write("\n");
      out.write("            ");

                String facultad = "";
                if (String.valueOf(request.getAttribute("facultad")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("facultad")));
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
      out.write("\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Nombre Asignatura</th>\n");
      out.write("                    <th>Tipo</th>\n");
      out.write("                    <th>Creditos</th>\n");
      out.write("\n");
      out.write("                    <th>Link asignatura</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th style=\"border: hidden\"></th>\n");
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
                            /*for (int i = 0; i < listaAsignaturasOrigen.size(); i++) {
                                System.out.println(listaAsignaturasOrigen.get(i).getNombre());
                            }*/

                            //List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestino");
                            //if (listaAsignaturasOrigen != null && listaAsignaturasDestino != null)
                            if (listaRA != null)
                                //for (Asignatura_Origen asignaturaO : listaAsignaturasOrigen) {
                                for (RelacionAsignaturas ra : listaRA) {
                                    //for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                                    //if (String.valueOf(asignaturaO.getCodigo()).equals(String.valueOf(asignaturaD.getCodigo_erasmus_Universidad_destino()))) {
                                    //System.out.println(asignaturaO.getNombre());

      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
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
      out.write("                            <td style=\"border: hidden\">---></td>\n");
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
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosOrigen")));
                                    sumaCreditosOrigen = String.valueOf(request.getAttribute("sumaCreditosOrigen"));
                                }
                            
      out.write(" \n");
      out.write("                            <th>Total creditos en la Universidad de Alcalá: ");
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
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosDestino")));
                                    sumaCreditosDestino = String.valueOf(request.getAttribute("sumaCreditosDestino"));
                                }
                            
      out.write(" \n");
      out.write("                            <th>Total creditos en la Universidad de Destino: ");
      out.print(sumaCreditosDestino);
      out.write("</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"tituloModificar\">  <h1 >MODIFICAR ASIGNATURA</h1></div>\n");
      out.write("            <div id=\"form7\">\n");
      out.write("                <select class=\"form-control\" id=\"listaAsignaturasModificar\" name=\"listaAsignaturasModificar\">\n");
      out.write("                    <option>Escoge una asignatura</option>\n");
      out.write("                    ");
 if (listaRA != null)
                            for (RelacionAsignaturas ra : listaRA) {
                                if (ra.getEstado().equals("Pendiente")) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(ra.getCodigo_destino());
      out.write('"');
      out.write('>');
      out.print(ra.getNombre_destino());
      out.print(" (" + ra.getCodigo_destino() + ")");
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
      out.write("                <div id=\"comentariosModificada\"> <label>Comentarios</label>\n");
      out.write("                    <input id=\"ComentariosModificada\" class=\"form-control\" name=\"ComentariosModificada\" type=\"textarea\" align=\"left\" size=\"50\"/></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"form8\">\n");
      out.write("\n");
      out.write("                <select class=\"form-control\" id=\"modificarEstado\" name=\"modificarEstado\">\n");
      out.write("                    <option>Escoge un estado</option>\n");
      out.write("                    <option>Aceptar</option>\n");
      out.write("                    <option>Rechazar</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butModificar\">\n");
      out.write("                <button>Modificar</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("            <div id=\"tituloCancelar\">  <h1 >CANCELAR ASIGNATURA</h1></div>\n");
      out.write("            <div id=\"form11\">\n");
      out.write("                <select class=\"form-control\" id=\"listaAsignaturasCancelar\" name=\"listaAsignaturasCancelar\">\n");
      out.write("                    <option>Escoge una asignatura</option>\n");
      out.write("                    ");
 if (listaRA != null)
                            for (RelacionAsignaturas ra : listaRA) {
                                if (ra.getEstado().equals("Aceptada")) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(ra.getCodigo_destino());
      out.write('"');
      out.write('>');
      out.print(ra.getNombre_destino());
      out.print(" (" + ra.getCodigo_destino() + ")");
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
      out.write("            </div>\n");
      out.write("            <div id=\"comentariosCancelada\">\n");
      out.write("             <div id=\"label1\"    <label>Comentarios</label></div>\n");
      out.write("                <input id=\"comentariosCancelada\" class=\"form-control\" name=\"ComentariosCancelada\" type=\"textarea\" align=\"left\" size=\"40\"/></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"butCancelar\">\n");
      out.write("                <button>Cancelar</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br><br><br>\n");
      out.write("        <div id=\"enlaceNuevo\">\n");
      out.write("            <a href=\"ProfesorController?accion=nuevoAlumno\">Dar de alta a alumno</a>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"ProfesorController?accion=nuevaEstancia\">Nueva estancia de alumno</a>\n");
      out.write("        </div>\n");
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
