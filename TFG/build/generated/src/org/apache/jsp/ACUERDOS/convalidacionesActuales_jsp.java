package org.apache.jsp.ACUERDOS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Estancia;
import modelo.Universidad_DestinoDAO;
import modelo.RelacionAsignaturas;
import java.util.List;

public final class convalidacionesActuales_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"C:\\Users\\Javier\\Documents\\GitHub\\TFG\\TFG\\src\\java\\css\\style.css\" type=\"text/css\">        <title>CONVALIDACIONES ACTUALES</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background:#F5F5F5;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>CONVALIDACIONES ACTUALES</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"div06\">VER CONVALIDACIONES ACTUALES</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"ProfesorController?accion=convalidacionesActuales\" method=\"POST\" autocomplete=\"off\">\n");
      out.write("\n");
      out.write("            <div id=\"form17\">\n");
      out.write("\n");
      out.write("                <select class=\"form-control\" id=\"listaEstancias\" name=\"listaEstancias\">\n");
      out.write("\n");
      out.write("                    <option>Escoge la estancia que deseas comprobar</option>\n");
      out.write("                    ");

                        Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
                        List<Estancia> listaEstancias = (List<Estancia>) request.getAttribute("listaEstancias");
                        if (listaEstancias != null)
                            for (Estancia estancia : listaEstancias) {
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(estancia.getId_estancia());
      out.write('"');
      out.write('>');
      out.print(estancia.getTipo() + " ");
      out.print(universidadDAO.obtenerNombre(estancia.getCodigo_erasmus_Universidad_destino()));
      out.print(" ("
                                + estancia.getCurso_academico() + ")");
      out.write("</option>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"butConfirmarEstancia\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button  id=\"butConfirmarEstancia\" class=\"btn btn-primary\" name=\"butConfirmarEstancia\" type=\"submit\" >Seleccionar</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"table4\">\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div id=\"titulo5\"> ASIGNATURAS RECONOCIDAS EN LA UNIVERSIDAD DE ALCALÁ\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"titulo6\"> ASIGNATURAS CURSADAS  EN LA UNIVERSIDAD DE DESTINO\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Nombre Asignatura</th>\n");
      out.write("                    <th>Tipo</th>\n");
      out.write("                    <th>Creditos</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th>Link asignatura</th>\n");
      out.write("\n");
      out.write("                    <th style=\"border: hidden\"></th>\n");
      out.write("\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Nombre Asignatura</th>\n");
      out.write("                    <th>Creditos</th>\n");
      out.write("                    <th>Link asignatura</th>\n");
      out.write("                    <th>Universidad</th>\n");
      out.write("                    <th>Fecha convalidacion</th>\n");
      out.write("                    <th>Curso academico</th>\n");
      out.write("                    <th>Estado</th>\n");
      out.write("                    <th>Comentarios</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                    <tbody>\n");
      out.write("\n");
      out.write("                        ");
 List<RelacionAsignaturas> listaRA = (List<RelacionAsignaturas>) request.getAttribute("listaRelacionAsignaturasConvalidacionesActuales");
                            /*for (int i = 0; i < listaAsignaturasOrigen.size(); i++) {
                                System.out.println(listaAsignaturasOrigen.get(i).getNombre());
                            }*/

                            //List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestinoBuscador");
                            if (listaRA != null)
                                for (RelacionAsignaturas ra : listaRA) {
                                    //if (String.valueOf(asignaturaO.getCodigo()).equals(String.valueOf(asignaturaD.getCodigo_Asignatura_Origen()))) {
                                    //System.out.println(asignaturaO.getNombre());

      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td>");
      out.print(ra.getCodigo_origen());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getNombre_origen());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getTipo());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getCreditos_origen());
      out.write("</td>\n");
      out.write("                            <td><a href=\"");
      out.print(ra.getInformacion_origen());
      out.write("\" target=\"_blank\" > link</a></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td style=\"border: hidden\">---></td>\n");
      out.write("                            <td>");
      out.print(ra.getCodigo_destino());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getNombre_destino());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getCreditos_destino());
      out.write("</td>\n");
      out.write("\n");
      out.write("                            <td><a href=\"");
      out.print(ra.getInformacion_destino());
      out.write("\" target=\"_blank\" > link</a></td>\n");
      out.write("                            <td>");
      out.print(ra.getNombre_universidad());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getFecha());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getCurso());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getEstado());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ra.getComentarios());
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                                }


                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"table6\">\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            ");
                                String sumaCreditosOrigen = "";
                                if (String.valueOf(request.getAttribute("sumaCreditosOrigen")) != "null") {
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosOrigen")));
                                    sumaCreditosOrigen = String.valueOf(request.getAttribute("sumaCreditosOrigen"));
                                }
                            
      out.write(" \n");
      out.write("                            <th>Total creditos aceptados en la Universidad de Alcalá: ");
      out.print(sumaCreditosOrigen);
      out.write("</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"table7\">\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            ");

                                String sumaCreditosDestino = "";
                                if (String.valueOf(request.getAttribute("sumaCreditosDestino")) != "null") {
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosDestino")));
                                    sumaCreditosDestino = String.valueOf(request.getAttribute("sumaCreditosDestino"));
                                }
                            
      out.write(" \n");
      out.write("                            <th>Total creditos aceptados en la Universidad de Destino: ");
      out.print(sumaCreditosDestino);
      out.write("</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <div id=\"volver5\">\n");
      out.write("            <a href=\"ProfesorController?accion=volverAlumno\">Volver</a>\n");
      out.write("\n");
      out.write("        </div>\n");
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
