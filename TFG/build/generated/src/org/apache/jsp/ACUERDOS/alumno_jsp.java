package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class alumno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\"> \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"div07\">ALUMNO</div>\n");
      out.write("        <form action=\"ProfesorController?accion=listarAsignaturas\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            ");

                String DNI = request.getAttribute("DNI_A").toString();

            
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div id=\"enlacesAlumno\">\n");
      out.write("            <a href=\"ProfesorController?accion=nuevasAsignaturasOrigen\">Nueva asignatura origen</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"ProfesorController?accion=nuevasAsignaturasDestino\">Nueva asignatura destino</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"ProfesorController?accion=nuevaConvalidacion\">Nueva convalidacion</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"ProfesorController?accion=buscarConvalidacion\">Buscar antiguas convalidaciones</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"ProfesorController?accion=convalidacionesActuales\">Estado convalidaciones actuales</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"ProfesorController?accion=cambiarPassword\">Cambiar contraseña</a>\n");
      out.write("        </div>\n");
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
