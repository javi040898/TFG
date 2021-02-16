package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>PROFESOR</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#3C82B6;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <h1>PROFESOR</h1>\n");
      out.write("\n");
      out.write("            \n");
      out.write("        \n");
      out.write("        <form action=\"ProfesorController?accion=listarAlumnos\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            <p align=\"center\"> \n");
      out.write("                <select class=\"form-control\" id=\"listaAlumnos\" name=\"listaAlumnos\">\n");
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
      out.write("            <button>Aceptar</button>\n");
      out.write("            <table border=\"1\" width=\"80%\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Codigo</th>\n");
      out.write("                        <th>Creditos</th>\n");
      out.write("                        <th>Nombre</th>\n");
      out.write("                        <th>Guia Docente</th>\n");
      out.write("                        <th>Link</th>\n");
      out.write("                        <th>Codigo destino</th>\n");
      out.write("                        <th>Creditos destino</th>\n");
      out.write("                        <th>Nombre destino</th>\n");
      out.write("                        <th>Guia Docente destino</th>\n");
      out.write("                        <th>Link</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("\n");
      out.write("                <tbody>\n");
      out.write("                <tr>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("codigo") );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("creditos") );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("nombre") );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("guia_docente") );
      out.write("</td>\n");
      out.write("                   <td><a href=\"");
      out.print( request.getAttribute("guia_docente") );
      out.write("\" > link</a></td>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("codigo_destino") );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("creditos_destino") );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("nombre_destino") );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( request.getAttribute("guia_docente_destino") );
      out.write("</td>\n");
      out.write("                   <td><a href=\"");
      out.print( request.getAttribute("guia_docente_destino") );
      out.write("\" > link</a></td>\n");
      out.write("                   \n");
      out.write("                   <td></td>\n");
      out.write("                   \n");
      out.write("                   <td></td>\n");
      out.write("                </tr> \n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("        </form>\n");
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
