<%-- 
    Document   : profesor
    Created on : 17-ene-2021, 19:35:12
    Author     : Javier
--%>

<%@page import="modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PROFESOR</title>
    </head>
    <body>
        <style>
            body{
                background:#3C82B6;
            }
        </style>
        <h1>PROFESOR</h1>

            
        
        <form action="ProfesorController?accion=listarAlumnos" method="POST" autocomplete="off">
            <p align="center"> 
                <select class="form-control" id="listaAlumnos" name="listaAlumnos">
                    <option>Escoge un alumno</option>
                    <%
                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        if (listaAlumnos != null)
                    for (Alumno alumno : listaAlumnos) {%>
                    <option value="<%=alumno.getDNI()%>"><%=alumno.getNombre()%><%=" " + alumno.getApellidos()%><%=" (" + alumno.getDNI() + " )"%></option>
                    <%}%>





                </select>


            <button>Aceptar</button>
            <table border="1" width="80%">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Creditos</th>
                        <th>Nombre</th>
                        <th>Guia Docente</th>
                        <th>Link</th>
                        <th>Codigo destino</th>
                        <th>Creditos destino</th>
                        <th>Nombre destino</th>
                        <th>Guia Docente destino</th>
                        <th>Link</th>
                    </tr>
                </thead>

                <tbody>
                <tr>
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
                   
                   <td></td>
                   
                   <td></td>
                </tr> 

                </tbody>


            </table>
            
            

        </form>


















    </body>
</html>
