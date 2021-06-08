package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Universidad_Destino;
import modelo.Grado;
import java.util.List;

public final class nuevoAlumno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>NUEVA ALUMNO</title>\n");
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
      out.write("        <form action=\"ProfesorController?accion=insertarAlumno\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            <div id=\"form10\">\n");
      out.write("                <h1>NUEVO ALUMNO</h1>\n");
      out.write("\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>Nombre</label>\n");
      out.write("                    <input id=\"Nombre\" class=\"form-control\" name=\"Nombre\" type=\"text\" align=\"left\"/>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>Apellidos</label>\n");
      out.write("                    <input id=\"Apellidos\" class=\"form-control\" name=\"Apellidos\" type=\"text\" align=\"left\"/>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>Contraseña</label>\n");
      out.write("                    <input id=\"PasswA\" class=\"form-control\" name=\"Password\" type=\"Password\" align=\"left\"/>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>Nombre Usuario</label>\n");
      out.write("                    <input id=\"Nombre_usuario\" class=\"form-control\" name=\"Nombre_usuario\" type=\"text\" align=\"left\"/>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label>DNI</label>\n");
      out.write("                    <input id=\"DNI_Alumno\" class=\"form-control\" name=\"DNI_Alumno\" type=\"text\" align=\"left\"/>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <label>Grado</label>\n");
      out.write("                <select class=\"form-control\" id=\"Grado\" name=\"Grado\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <option>Escoge un grado</option>\n");
      out.write("                    ");


                        List<Grado> listaGrados = (List<Grado>) request.getAttribute("listaGrados");
                        if (listaGrados != null)
                            for (Grado grado : listaGrados) {
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(grado.getCodigo());
      out.write('"');
      out.write('>');
      out.print(grado.getNombre());
      out.print(" (" + grado.getCodigo() + " )");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butAltaAlumno\">\n");
      out.write("                <button  id=\"Alta\" name=\"Alta\" type=\"submit\">Alta</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"volver9\">\n");
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
