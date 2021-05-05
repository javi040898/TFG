<%-- 
    Document   : profesor
    Created on : 17-ene-2021, 19:35:12
    Author     : Javier
--%>

<%@page import="modelo.RelacionAsignaturas"%>
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <style>
            body{
                background:#F5F5F5;
            }
        </style>
    </head>
    <body>

        <div class="div01"> PROFESOR</div>



        <form action="ProfesorController?accion=listarAlumnos" method="POST" autocomplete="off">
            <p align="center"> 
            <div id="form6">
                <select class="form-control" id="listaAlumnos" name="listaAlumnos">



                    <option>Escoge un alumno</option>
                    <%

                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        if (listaAlumnos != null)
                            for (Alumno alumno : listaAlumnos) {%>
                    <option value="<%=alumno.getDNI()%>"><%=alumno.getNombre()%><%=" " + alumno.getApellidos()%><%=" (" + alumno.getDNI() + " )"%></option>
                    <% }%>





                </select>


            </div>
            <div id="butAceptar">
                <button>Aceptar</button>
            </div>
            <div id="NombreAlumno">Nombre <%=String.valueOf(request.getAttribute("nombreAlumno"))%>
            </div>

            <div id="ApellidosAlumno">Apellidos <%=String.valueOf(request.getAttribute("apellidosAlumno"))%>
            </div>
            <div id="table1">
                <table>
                    <thead>

                        <tr>
                    <div id="titulo1"> ASIGNATURAS A RECONOCER EN LA UNIVERSIDAD DE ALCALÁ
                    </div>
                    <div id="titulo2"> ASIGNATURAS CURSADAS  EN LA UNIVERSIDAD DE DESTINO
                    </div>





                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Tipo</th>
                    <th>Creditos</th>

                    <th>Link de asignatura</th>


                    <th style="border: hidden"></th>

                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Creditos</th>
                    <th>Link de asignatura</th>
                    <th>Fecha convalidacion</th>
                    <th>Curso academico</th>
                    <th>Estado</th>
                    <th>Comentarios</th>

                    </tr>
                    </thead>

                    <tbody>

                        <% List<RelacionAsignaturas> listaRA = (List<RelacionAsignaturas>) request.getAttribute("listaRA");
                            /*for (int i = 0; i < listaAsignaturasOrigen.size(); i++) {
                                System.out.println(listaAsignaturasOrigen.get(i).getNombre());
                            }*/

                            //List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestino");
                            //if (listaAsignaturasOrigen != null && listaAsignaturasDestino != null)
                            if (listaRA != null)
                                //for (Asignatura_Origen asignaturaO : listaAsignaturasOrigen) {
                                for (RelacionAsignaturas ra : listaRA) {
                                    //for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                                    //if (String.valueOf(asignaturaO.getCodigo()).equals(String.valueOf(asignaturaD.getCodigo_erasmus_Universidad_destino()))) {
                                    //System.out.println(asignaturaO.getNombre());
                        %>
                        <tr>

                            <td><%=ra.getCodigo_origen()%></td>
                            <td><%=ra.getNombre_origen()%></td>
                            <td><%=ra.getTipo()%></td>
                            <td><%=ra.getCreditos_origen()%></td>
                            <td><a href="<%=ra.getInformacion_origen()%>" target="_blank" > link</a></td>


                            <td style="border: hidden">---></td>
                            <td><%=ra.getCodigo_destino()%></td>
                            <td><%=ra.getNombre_destino()%></td>
                            <td><%=ra.getCreditos_destino()%></td>

                            <td><a href="<%=ra.getInformacion_destino()%>" target="_blank" > link</a></td>
                            <td><%=ra.getFecha()%></td>
                            <td><%=ra.getCurso()%></td>
                            <td><%=ra.getEstado()%></td>
                            <td><%=ra.getComentarios()%></td>



                        </tr>
                        <%
                                }
                            // }

                            // }%>



                    </tbody>


                </table>
            </div>

            <div id="table3">
                <table>
                    <thead>
                        <tr>
                            <th>Total creditos: <%=String.valueOf(request.getAttribute("sumaCreditos"))%></th>
                        </tr>
                    </thead>

                </table>
            </div>




            <div id="tituloModificar">  <h1 >MODIFICAR ASIGNATURA</h1></div>
            <div id="form7">
                <select class="form-control" id="listaAsignaturasModificar" name="listaAsignaturasModificar">
                    <option>Escoge una asignatura</option>
                    <% if (listaRA != null)
                            for (RelacionAsignaturas ra : listaRA) {
                                if (ra.getEstado().equals("Pendiente")) {
                    %>
                    <option value="<%=ra.getCodigo_destino()%>"><%=ra.getNombre_destino()%><%=" (" + ra.getCodigo_destino() + ")"%></option>
                    <% }
                        }%>





                </select>
                <div id="comentarios"> <label>Comentarios</label>
                    <input id="Comentarios" class="form-control" name="Comentarios" type="textarea" align="left" size="50"/></div>

            </div>
            <div id="form8">

                <select class="form-control" id="modificarEstado" name="modificarEstado">
                    <option>Escoge un estado</option>
                    <option>Aceptar</option>
                    <option>Rechazar</option>
                </select>
            </div>
            <div id="butModificar">
                <button>Modificar</button>
            </div>






        </form>

        <br>
        <br><br><br>
        <div id="enlaceNuevo">
            <a href="ProfesorController?accion=nuevaEstancia">Nueva estancia de alumno</a>
        </div>


















    </body>
</html>
