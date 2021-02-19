<%-- 
    Document   : profesor
    Created on : 17-ene-2021, 19:35:12
    Author     : Javier
--%>

<%@page import="modelo.Asignatura_Destino"%>
<%@page import="modelo.Asignatura_Origen"%>
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
                        <th>Codigo</th>
                        <th>Creditos</th>
                        <th>Nombre</th>
                        <th>Guia Docente</th>
                        <th>Link</th>
                        <th>Codigo destino</th>
                        <th>Estado</th>
                    </tr>
                </thead>

                <tbody>
                <tr>
                    <% List<Asignatura_Origen> listaAsignaturasOrigen = (List<Asignatura_Origen>)request.getAttribute("listaAsignaturasOrigen");
                    List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>)request.getAttribute("listaAsignaturasDestino");
            if(listaAsignaturasOrigen != null && listaAsignaturasDestino!=null)
                for(Asignatura_Origen asignaturaO : listaAsignaturasOrigen){
                    for(Asignatura_Destino asignaturaD : listaAsignaturasDestino){
                        if(asignaturaO.getCodigo() == asignaturaD.getCodigo_Asignatura_Origen()){
                            %>
                            <tr>
                            <td><%=asignaturaO.getCodigo()%></td>
                            <td><%=asignaturaO.getCreditos()%></td>
                            <td><%=asignaturaO.getNombre()%></td>
                            <td><%=asignaturaO.getGuia_docente()%></td>
                            <td><a href="<%=asignaturaO.getGuia_docente()%>" > link</a></td>
                            <td><%=asignaturaD.getCodigo()%></td>
                            <td><%=asignaturaD.getCreditos()%></td>
                            <td><%=asignaturaD.getNombre()%></td>
                            <td><%=asignaturaD.getGuia_docente()%></td>
                            <td><a href="<%=asignaturaD.getGuia_docente()%>" > link</a></td>
                            <td><%=asignaturaD.getCodigo_Asignatura_Origen()%></td>
                            <td><%=asignaturaD.getEstado()%></td>
                            
                            </tr>
                            <%
                        }
                    }
                    
                }%>
                
                 

                </tbody>


            </table>
            
            

        </form>


















    </body>
</html>
