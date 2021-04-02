package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>PROFESOR</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#3C82B6;\n");
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
      out.write("            </div>\n");
      out.write("            <div id=\"butAceptar\">\n");
      out.write("                <button>Aceptar</button>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"table1\">\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                    <div id=\"titulo1\"> <h1>ASIGNATURAS ORIGEN \n");
      out.write("                        </h1></div>\n");
      out.write("                    <div id=\"titulo2\"> <h1>ASIGNATURAS DESTINO \n");
      out.write("                        </h1></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Creditos</th>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Guia Docente</th>\n");
      out.write("                    <th>Link</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th style=\"border: hidden\"></th>\n");
      out.write("\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Creditos</th>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Guia Docente</th>\n");
      out.write("                    <th>Link</th>\n");
      out.write("                    <th>Codigo destino</th>\n");
      out.write("                    <th>Estado</th>\n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                    <tbody>\n");
      out.write("\n");
      out.write("                        ");
 List<Asignatura_Origen> listaAsignaturasOrigen = (List<Asignatura_Origen>) request.getAttribute("listaAsignaturasOrigen");
                            /*for (int i = 0; i < listaAsignaturasOrigen.size(); i++) {
                                System.out.println(listaAsignaturasOrigen.get(i).getNombre());
                            }*/

                            List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestino");
                            if (listaAsignaturasOrigen != null && listaAsignaturasDestino != null)
                                for (Asignatura_Origen asignaturaO : listaAsignaturasOrigen) {
                                    for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                                        if (String.valueOf(asignaturaO.getCodigo()).equals(String.valueOf(asignaturaD.getCodigo_Asignatura_Origen()))) {
                                            //System.out.println(asignaturaO.getNombre());
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                            <td>");
      out.print(asignaturaO.getCodigo());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(asignaturaO.getCreditos());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(asignaturaO.getNombre());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(asignaturaO.getGuia_docente());
      out.write("</td>\n");
      out.write("                            <td><a href=\"");
      out.print(asignaturaO.getGuia_docente());
      out.write("\" > link</a></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td style=\"border: hidden\">---></td>\n");
      out.write("                            <td>");
      out.print(asignaturaD.getCodigo());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(asignaturaD.getCreditos());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(asignaturaD.getNombre());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(asignaturaD.getGuia_docente());
      out.write("</td>\n");
      out.write("                            <td><a href=\"");
      out.print(asignaturaD.getGuia_docente());
      out.write("\" > link</a></td>\n");
      out.write("                            <td>");
      out.print(asignaturaD.getCodigo_Asignatura_Origen());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(asignaturaD.getEstado());
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                                    }
                                }

                            }
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
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"tituloModificar\">  <h1 >MODIFICAR ASIGNATURA</h1></div>\n");
      out.write("            <div id=\"form7\">\n");
      out.write("                <select class=\"form-control\" id=\"listaAsignaturasModificar\" name=\"listaAsignaturasModificar\">\n");
      out.write("                    <option>Escoge una asignatura</option>\n");
      out.write("                    ");
 if (listaAsignaturasDestino != null)
                            for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                                if (asignaturaD.getEstado().equals("Pendiente")) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(asignaturaD.getCodigo());
      out.write('"');
      out.write('>');
      out.print(asignaturaD.getNombre());
      out.print(" (" + asignaturaD.getCodigo() + ")");
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
      out.write("                <a href=\"ProfesorController?accion=nuevoAlumno\">Dar de alta alumno</a>\n");
      out.write("            </div>\n");
      out.write("        \n");
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
