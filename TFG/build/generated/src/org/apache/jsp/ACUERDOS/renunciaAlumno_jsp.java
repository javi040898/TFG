package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Estancia;
import modelo.Alumno;
import java.util.List;
import modelo.Universidad_DestinoDAO;

public final class renunciaAlumno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>PROFESOR</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"ProfesorController?accion=listarAlumnosRenuncia\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("            <p align=\"center\"> \n");
      out.write("            <div id=\"form6\">\n");
      out.write("\n");
      out.write("                <h1>NUEVA RENUNCIA</h1>\n");
      out.write("\n");
      out.write("                <select class=\"form-control\" id=\"listaEstanciasAlumnosRenuncia\" name=\"listaEstanciasAlumnosRenuncia\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <option>Escoge una estancia y alumno</option>\n");
      out.write("                    ");

                        Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        List<Estancia> listaEstancias = (List<Estancia>) request.getAttribute("listaEstancias");

                        if (listaAlumnos != null)
                            if (listaEstancias != null)
                                for (Estancia estancia : listaEstancias) {
                                    for (Alumno alumno : listaAlumnos) {

                                        System.out.println("DNI1:" + alumno.getDNI() + " DNI2:" + estancia.getDNI_alumno());
                                        if (alumno.getDNI().equals(estancia.getDNI_alumno())) {


                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(estancia.getId_estancia());
      out.write('"');
      out.write('>');
      out.print(estancia.getTipo() + " ");
      out.print(universidadDAO.obtenerNombre(estancia.getCodigo_erasmus_Universidad_destino()));
      out.print(" ("
                                + estancia.getCurso_academico() + ") ");
      out.print(alumno.getNombre());
      out.print(" " + alumno.getApellidos());
      out.print(" (" + alumno.getDNI() + ") ");
      out.write("</option>\n");
      out.write("                        ");

                                        break;
                                    }

                                }
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
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"butAceptarRenuncia\">\n");
      out.write("                <button>Aceptar</button>\n");
      out.write("            </div>\n");
      out.write("                            \n");
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
