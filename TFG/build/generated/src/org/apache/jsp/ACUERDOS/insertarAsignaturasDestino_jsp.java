package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.Universidad_Destino;

public final class insertarAsignaturasDestino_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>INSERTAR ASIGNATURAS</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>INSERTAR ASIGNATURAS</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"div02\">INSERTAR ASIGNATURAS</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"ProfesorController?accion=insertarAsignaturasDestino\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div id=\"form2\">\n");
      out.write("                    <h1>ASIGNATURA DESTINO</h1>\n");
      out.write("                    <label>Codigo Asignatura</label>\n");
      out.write("                    <input id=\"CodigoD1\" class=\"form-control\" name=\"CodigoD\" type=\"text\" align=\"left\"/>\n");
      out.write("                    <label>Nombre Asignatura</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"NombreD\" id=\"NombreD1\" placeholder=\"\">\n");
      out.write("                    <label>Creditos</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"CreditosD\" id=\"CreditosD1\" placeholder=\"\">\n");
      out.write("                    <label>Informacion</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"InformacionD\" id=\"InformacionD1\" placeholder=\"\">\n");
      out.write("                    <label>Universidad</label>\n");
      out.write("\n");
      out.write("                    <select class=\"form-control\" id=\"listaUniversidadesDsetino\" name=\"listaUniversidadesDsetino\">\n");
      out.write("\n");
      out.write("                        <option>Escoge un universidad</option>\n");
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
      out.print(" (" + universidad.getCiudad() + " )");
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
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <br><br><br>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butInsertarAsignaturas\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button  id=\"insertarAsignaturas\" class=\"btn btn-primary\" name=\"insertarAsignaturas\" type=\"submit\" >Insertar</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <div id=\"volver2\">\n");
      out.write("            <a href=\"ProfesorController?accion=volverAlumno\">Volver</a>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
