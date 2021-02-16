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


            </table>
    </body>
</html>
