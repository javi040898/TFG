package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>INICIAR SESION</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            #cuadroUsuario{\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                padding:10px;\n");
      out.write("                position:absolute;\n");
      out.write("                top:20px;\n");
      out.write("                right:400px;\n");
      out.write("                width:500px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #cuadroPassword{\n");
      out.write("                float:left;\n");
      out.write("\n");
      out.write("                margin:25px;\n");
      out.write("                padding:10px;\n");
      out.write("                position:absolute;\n");
      out.write("                top:120px;\n");
      out.write("                right:400px;\n");
      out.write("                width: 500px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #butLogin{\n");
      out.write("\n");
      out.write("                position:absolute;\n");
      out.write("\n");
      out.write("                display:block;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                left:420px;\n");
      out.write("                top:250px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("                background:#F5F5F5;\n");
      out.write("                font-family: sans-serif; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <h1 align = \"center\"><font face=\"Courier\" size=6>\n");
      out.write("            PROPUESTA LEARNING AGREEMENT ESTUDIANTES UNIVERSIDAD DE ALCALA</font></h1>\n");
      out.write("        <p align=\"center\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm\">\n");
      out.write("\n");
      out.write("                    <form method=\"POST\" action=\"PropuestaLA?accion=comprobarLogin\" autocomplete=\"off\" >\n");
      out.write("                        <div class=\"form-group\" id=\"cuadroUsuario\">\n");
      out.write("                            <label>Usuario</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"usuario\" id=\"usuario\" placeholder=\"\" size=\"20\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" id=\"cuadroPassword\">\n");
      out.write("                            <label>Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\" placeholder=\"\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div id=\"butLogin\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\" name=\"login\" >Login</button>\n");
      out.write("                        </div>\n");
      out.write("                        ");

                            String mensaje = (String) request.getAttribute("error");
                            if (mensaje == "error") {
      out.write("\n");
      out.write("                        <script>\n");
      out.write("                            alert('Credenciales introducidas incorrectas');\n");
      out.write("                        </script>");
}
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
