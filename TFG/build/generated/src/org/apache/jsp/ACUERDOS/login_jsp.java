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
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\"> \n");
      out.write("   \n");
      out.write("        <title>INICIAR SESION</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <h1 align = \"center\"><font face=\"Courier\" size=7>\n");
      out.write("            INICIAR SESION</font></h1>\n");
      out.write("        <p align=\"center\"> \n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm\">\n");
      out.write("\n");
      out.write("                    <form method=\"POST\" action=\"ProfesorController?accion=comprobarLogin\" autocomplete=\"off\" >\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Usuario</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"usuario\" id=\"usuario\" placeholder=\"\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\" placeholder=\"\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\" name=\"login\" >Login</button>\n");
      out.write("                        ");

                            String mensaje = (String) request.getAttribute("error");
                            if (mensaje == "error") {
      out.write("\n");
      out.write("                                <script>\n");
      out.write("                                alert('Credenciales introducidas incorrectas');\n");
      out.write("                                </script>");
}
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                    ");

                        /* Connection con = null;
                        Connection con2 = null;
                        Statement st = null;
                        Statement st2 = null;
                        ResultSet rs = null;
                        ResultSet rs2 = null;
                        if (request.getParameter("login") != null) {
                            String user = request.getParameter("usuario");
                            String password = request.getParameter("password");
                            HttpSession sesion = request.getSession();
                            HttpSession sesion2 = request.getSession();
                            try {
                                Class.forName("org.postgresql.Driver").newInstance();
                                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TFG", "postgres", "postgres");
                                st = con.createStatement();
                                //rs = st.executeQuery(" select * from Profesor where usuario='" + user + "' and passw='" + password + "'; ");
                                rs = st.executeQuery(" select * from Profesor where usuario='" + user + "' and passw='" + password + "'; ");
                                
                                while(rs.next()){
                                    sesion.setAttribute("usuario", rs.getString("usuario"));
                                    sesion.setAttribute("password", rs.getString("passw"));
                                    response.sendRedirect("profesor.jsp");
                                }
                                rs2 = st.executeQuery(" select * from Alumno where usuario='" + user + "' and passw='" + password + "'; ");
                                while(rs2.next()){
                                    sesion.setAttribute("usuario2", rs2.getString("usuario"));
                                    sesion.setAttribute("password2", rs2.getString("passw"));
                                    response.sendRedirect("alumno.jsp");
                                }
                                
                                   out.print(" <div class=\"alert alert-danger\" role=\"alert\"> Usuario no valido </div>"); */

 /*while (rs.next()) {
                                    
                                    sesion.setAttribute("usuario", rs.getString("usuario"));
                                    sesion.setAttribute("password", rs.getString("passw"));
                                    response.sendRedirect("profesor.jsp");
                                }*/
                        //out.print(" <div class=\"alert alert-danger\" role=\"alert\"> Usuario no valido </div>");
                        /*  } catch (Exception e) {
                            }
                        }*/
                    
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    ");
/*
        if (request.getParameter("login") != null) {
            String user = request.getParameter("usuario");
            String password = request.getParameter("passw");
            HttpSession sesion = request.getSession();
            if (user.equals("admin") && password.equals("admin")) {
                sesion.setAttribute("logueado", "1");
                sesion.setAttribute("user", user);
                response.sendRedirect("index.jsp");
            } else {
                out.print("usuario o contraseña invalidos");
            }
        }*/
    
      out.write("\n");
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
