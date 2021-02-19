<%-- 
    Document   : asignaturas
    Created on : 15-feb-2021, 19:30:18
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Creditos</th>
                        <th>Nombre</th>
                        <th>Guia Docente</th>
                    </tr>
                </thead>

                <tbody>
                <tr>
                   <td><%= request.getAttribute("codigo") %></td>
                   <td><%= request.getAttribute("creditos") %></td>
                   <td><%= request.getAttribute("nombre") %></td>
                   <td><%= request.getAttribute("guia_docente") %></td>
                   <td></td>
                </tr> 

                </tbody>

 <td><%= request.getAttribute("codigo") %></td>
                   <td><%= request.getAttribute("creditos") %></td>
                   <td><%= request.getAttribute("nombre") %></td>
                   <td><%= request.getAttribute("guia_docente") %></td>
                   <td><a href="<%= request.getAttribute("guia_docente") %>" > link</a></td>
                   <td><%= request.getAttribute("codigo_destino") %></td>
                   <td><%= request.getAttribute("creditos_destino") %></td>
                   <td><%= request.getAttribute("nombre_destino") %></td>
                   <td><%= request.getAttribute("guia_docente_destino") %></td>
                   <td><a href="<%= request.getAttribute("guia_docente_destino") %>" > link</a></td>
                   <td><%= request.getAttribute("estado") %></td>
            </table>
    </body>
    
    
                <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Creditos</th>
                        <th>Nombre</th>
                        <th>Guia Docente</th>
                        <th>Link</th>
                    </tr>
                </thead>

                <tbody>
                <tr>
                    <% List<Asignatura_Origen> listaAsignaturasOrigen = (List<Asignatura_Origen>)request.getAttribute("listaAsignaturasOrigen");
            if(listaAsignaturasOrigen != null)
                for(Asignatura_Origen asignatura : listaAsignaturasOrigen){%>
                 <tr>
                   <td><%=asignatura.getCodigo()%></td>
                   <td><%=asignatura.getCreditos()%></td>
                   <td><%=asignatura.getNombre()%></td>
                   <td><%=asignatura.getGuia_docente()%></td>
                   <td><a href="<%=asignatura.getGuia_docente()%>" > link</a></td>
                   
                   <%}%>
                </tr> 

                </tbody>


            </table>
</html>
