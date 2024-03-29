package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Alumno;
import modelo.Alumno;
import modelo.Universidad_Destino;
import modelo.Grado;
import java.util.List;

public final class nuevaEstancia_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>NUEVA ESTANCIA</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"ProfesorController?accion=insertarEstancia\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            <div id=\"form10\">\n");
      out.write("                <h1>NUEVA ESTANCIA</h1>\n");
      out.write("\n");
      out.write("                <select class=\"form-control\" id=\"listaAlumnosEstancia\" name=\"listaAlumnosEstancia\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <option>Escoge un alumno</option>\n");
      out.write("                    ");


                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnosEstancia");
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
      out.write("                <label>Tipo de estancia</label>\n");
      out.write("                <select class=\"form-control\" name=\"Tipo\" id=\"Tipo\">\n");
      out.write("\n");
      out.write("                    <option>Escoge un tipo de estancia</option>\n");
      out.write("\n");
      out.write("                    <option>KA103</option>\n");
      out.write("\n");
      out.write("                    <option>KA107</option>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </select>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>Curso Academico</label>\n");
      out.write("                    <input id=\"Curso\" class=\"form-control\" name=\"Curso\" type=\"text\" align=\"left\"/>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>Duracion</label>\n");
      out.write("                    <select class=\"form-control\" name=\"Duracion\" id=\"Duracion\">\n");
      out.write("\n");
      out.write("                        <option>Escoge una duracion</option>\n");
      out.write("\n");
      out.write("                        <option>1º cuatrimestre</option>\n");
      out.write("\n");
      out.write("                        <option>2º cuatrimestre</option>\n");
      out.write("\n");
      out.write("                        <option>Anual</option>\n");
      out.write("\n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>Universidad</label>\n");
      out.write("                    <select class=\"form-control\" id=\"Universidad\" name=\"Universidad\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <option>Escoge una universidad</option>\n");
      out.write("                        ");


                            List<Universidad_Destino> listaUniversidades = (List<Universidad_Destino>) request.getAttribute("listaUniversidades");
                            if (listaUniversidades != null)
                                for (Universidad_Destino universidad : listaUniversidades) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(universidad.getCodigo_erasmus());
      out.write('"');
      out.write('>');
      out.print(universidad.getNombre());
      out.print(" (" + universidad.getCodigo_erasmus() + " )");
      out.write("</option>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butAltaEstancia\">\n");
      out.write("                <button  id=\"Alta\" name=\"Alta\" type=\"submit\">Alta</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"volver10\">\n");
      out.write("                <a href=\"ProfesorController?accion=volverProfesor\">Volver</a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
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
