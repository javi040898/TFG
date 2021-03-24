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
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>PROFESOR</title>
    </head>
    <body>

        <div class="div01"> PROFESOR</div>



        <form action="ProfesorController?accion=listarAlumnos" method="POST" autocomplete="off">
            <p align="center"> 
                <select class="form-control" id="listaAlumnos" name="listaAlumnos">
                    <option>Escoge un alumno</option>
                    <%
                        
                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        if (listaAlumnos != null)
                            for (Alumno alumno : listaAlumnos) {%>
                    <option value="<%=alumno.getDNI()%>"><%=alumno.getNombre()%><%=" " + alumno.getApellidos()%><%=" (" + alumno.getDNI() + " )"%></option>
                    <% } %>





                </select>


                <button>Aceptar</button>

            <div id="table1">
                <table>
                    <thead>

                        <tr>
                    <div><h1>ASIGNATURAS ORIGEN 
                            ASIGNATURAS DESTINO</h1></div>





                    <th>Codigo</th>
                    <th>Creditos</th>
                    <th>Nombre</th>
                    <th>Guia Docente</th>
                    <th>Link</th>

                    <th style="border: hidden"></th>

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
                        
                            <% List<Asignatura_Origen> listaAsignaturasOrigen = (List<Asignatura_Origen>) request.getAttribute("listaAsignaturasOrigen");
                                /*for (int i = 0; i < listaAsignaturasOrigen.size(); i++) {
                                    System.out.println(listaAsignaturasOrigen.get(i).getNombre());
                                }*/

                                List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestino");
                                if (listaAsignaturasOrigen != null && listaAsignaturasDestino != null)
                                    for (Asignatura_Origen asignaturaO : listaAsignaturasOrigen) {
                                        for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                                            if (String.valueOf(asignaturaO.getCodigo()).equals(String.valueOf(asignaturaD.getCodigo_Asignatura_Origen()))) {
                                                System.out.println(asignaturaO.getNombre());
                            %>
                        <tr>

                            <td><%=asignaturaO.getCodigo()%></td>
                            <td><%=asignaturaO.getCreditos()%></td>
                            <td><%=asignaturaO.getNombre()%></td>
                            <td><%=asignaturaO.getGuia_docente()%></td>
                            <td><a href="<%=asignaturaO.getGuia_docente()%>" > link</a></td>
                            <

                            <td style="border: hidden">---></td>
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
            </div>

            <br>
            <br><br><br>


            <h1 >MODIFICAR ASIGNATURA</h1>
            <select class="form-control" id="listaAsignaturasModificar" name="listaAsignaturasModificar">
                <option>Escoge una asignatura</option>
                <% if (listaAsignaturasDestino != null)
                        for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                            if (asignaturaD.getEstado().equals("Pendiente")) {
                %>
                <option value="<%=asignaturaD.getCodigo()%>"><%=asignaturaD.getNombre()%><%=" (" + asignaturaD.getCodigo() + ")"%></option>
                <% }
                    }%>





            </select>

            <select class="form-control" id="modificarEstado" name="modificarEstado">
                <option>Escoge un estado</option>
                <option>Aceptar</option>
                <option>Rechazar</option>
            </select>


            <button>Modificar</button>





        </form>

        <br>
        <br><br><br>

        <a href="ProfesorController?accion=nuevoAlumno">Dar de alta alumno</a>

















    </body>
</html>
