package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cambiarContraseña_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>CAMBIO CONTRASEÑA</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>CAMBIAR CONTRASEÑA</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"ProfesorController?accion=cambiarPassw\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("\n");
      out.write("            <div id=\"form9\">\n");
      out.write("                <h1>CAMBIAR CONTRASEÑA</h1>\n");
      out.write("                <label>Contraseña antigua</label>\n");
      out.write("                <input id=\"PasswA\" class=\"form-control\" name=\"PasswA\" type=\"password\" align=\"left\"/>\n");
      out.write("                <label>Contraseña nueva</label>\n");
      out.write("                <input type=\"password\" class=\"form-control\" name=\"PasswN1\" id=\"PasswN1\" placeholder=\"\">\n");
      out.write("                <label>Repetir contraseña nueva</label>\n");
      out.write("                <input type=\"password\" class=\"form-control\" name=\"PasswN2\" id=\"PasswN2\" placeholder=\"\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butCambiar\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button  id=\"butCambiar\" class=\"btn btn-primary\" name=\"butCambiar\" type=\"submit\" >Cambiar</button>\n");
      out.write("            </div>\n");
      out.write("            ");

                String mensaje = (String) request.getAttribute("confirmacion");
                System.out.println("mensaje: " + mensaje);
                if (mensaje == "error") {
      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert('Cambio de contraseña incorrecto');\n");
      out.write("            </script>");
}
      out.write("\n");
      out.write("            ");
if (mensaje == "correcto") {
      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert('Cambio de contraseña correcto');\n");
      out.write("            </script>");
}
      out.write("\n");
      out.write("            \n");
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
