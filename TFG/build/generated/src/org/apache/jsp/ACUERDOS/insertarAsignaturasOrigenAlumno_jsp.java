package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.Universidad_Destino;

public final class insertarAsignaturasOrigenAlumno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">     <title>INSERTAR ASIGNATURAS ORIGEN</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("            }\n");
      out.write("            #form1,#form2{\n");
      out.write("\n");
      out.write("                float:left;\n");
      out.write("                left:530px;\n");
      out.write("                margin:50px;\n");
      out.write("                padding:60px;\n");
      out.write("\n");
      out.write("                position:relative;\n");
      out.write("                top:-10px;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #butInsertarAsignaturasOrigen{\n");
      out.write("\n");
      out.write("                position:absolute;\n");
      out.write("\n");
      out.write("                display:block;\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                left:855px;\n");
      out.write("                top:540px;\n");
      out.write("\n");
      out.write("                background:#0CF;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
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
      out.write("        </style>\n");
      out.write("        <title>INSERTAR ASIGNATURAS ORIGEN</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <form action=\"PropuestaLA?accion=insertarAsignaturasOrigenAlumno\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("\n");
      out.write("                <div id=\"form1\">\n");
      out.write("                    <h1>NUEVA ASIGNATURA ORIGEN</h1>\n");
      out.write("                    <label>Codigo Asignatura</label>\n");
      out.write("                    <input id=\"CodigoO\" class=\"form-control\" name=\"CodigoO\" type=\"text\" align=\"left\"/>\n");
      out.write("                    <label>Nombre Asignatura</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"NombreO\" id=\"NombreO\" placeholder=\"\">\n");
      out.write("                    <label>Creditos</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"CreditosO\" id=\"CreditosO\" placeholder=\"\">\n");
      out.write("                    <label>Tipo Asignatura</label>\n");
      out.write("                    <select class=\"form-control\" id=\"TipoO\" name=\"TipoO\">\n");
      out.write("                        <option>Escoge un tipo</option>\n");
      out.write("                        <option>BASICA</option>\n");
      out.write("                        <option>OBLIGATORIA</option>\n");
      out.write("                        <option>OPTATIVA</option>\n");
      out.write("                        <option>TRANSVERSAL</option>\n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                    <label>Informacion (pagina web)</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"InformacionO\" id=\"Informacion\" placeholder=\"\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <br><br><br>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butInsertarAsignaturasOrigen\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button  id=\"insertarAsignaturas\" class=\"btn btn-primary\" name=\"insertarAsignaturas\" type=\"submit\" >Insertar</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <div id=\"volver\">\n");
      out.write("            <a href=\"PropuestaLA?accion=volverAlumno\">Volver</a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            String mensaje = (String) request.getAttribute("confirmacion");
            if (mensaje == "error") {
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert('No se ha podido dar de alta la asignatura');\n");
      out.write("        </script>");
}
      out.write("\n");
      out.write("        ");
if (mensaje == "correcto") {
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert('Asignatura insertada correctamente');\n");
      out.write("        </script>");
}
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
