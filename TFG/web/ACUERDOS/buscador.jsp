<%-- 
    Document   : buscador
    Created on : 01-abr-2021, 17:54:10
    Author     : Javier
--%>

<%@page import="modelo.RelacionAsignaturas"%>
<%@page import="modelo.Asignatura_Destino"%>
<%@page import="modelo.Asignatura_Origen"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>BUSCADOR DE CONVALIDACIONES</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>BUSCADOR DE CONVALIDACION</title>
    </head>
    <body>
        <div class="div06">BUSCADOR DE CONVALIDACIONES EN CURSOS ANTERIORES</div>


        <form action="ProfesorController?accion=buscadorConvalidacion" method="POST" autocomplete="off">



            <div id="form5">

                <label>Introduce el código de la asignatura que deseas convalidar  </label>
                <input id="CodigoBuscador" class="form-control" name="CodigoBuscador" type="text" align="left"/>

            </div>



            <br>

            <br><br><br>
            <div id="butBuscador">


                <button  id="Buscador" class="btn btn-primary" name="Buscador" type="submit" >Buscar</button>
            </div>


            <div id="table2">
                <table>
                    <thead>

                        <tr>


                    <div id="titulo3"> ASIGNATURAS RECONOCIDAS EN LA UNIVERSIDAD DE ALCALÁ
                    </div>
                    <div id="titulo4"> ASIGNATURAS CURSADAS  EN LA UNIVERSIDAD DE DESTINO
                    </div>





                    <th>Codigo</th>
                    <th>Nombre Asignatura</th>
                    <th>Tipo</th>
                    <th>Creditos</th>


                    <th>Link asignatura</th>

                    <th style="border: hidden"></th>

                    <th>Codigo</th>
                    <th>Nombre Asignatura</th>
                    <th>Creditos</th>
                    <th>Link asignatura</th>
                    <th>Universidad</th>
                    <th>Fecha convalidacion</th>
                    <th>Curso academico</th>
                    <th>Estado</th>
                    <th>Comentarios</th>




                    </tr>
                    </thead>

                    <tbody>

                        <% List<RelacionAsignaturas> listaRA = (List<RelacionAsignaturas>) request.getAttribute("listaRelacionAsignaturasOrigenBuscador");
                            /*for (int i = 0; i < listaAsignaturasOrigen.size(); i++) {
                                System.out.println(listaAsignaturasOrigen.get(i).getNombre());
                            }*/

                            //List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestinoBuscador");
                            if (listaRA != null)
                                for (RelacionAsignaturas ra : listaRA) {
                                    //if (String.valueOf(asignaturaO.getCodigo()).equals(String.valueOf(asignaturaD.getCodigo_Asignatura_Origen()))) {
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
                            <td><%=ra.getNombre_universidad()%></td>
                            <td><%=ra.getFecha()%></td>
                            <td><%=ra.getCurso()%></td>
                            <td><%=ra.getEstado()%></td>
                            <td><%=ra.getComentarios()%></td>




                        </tr>
                        <%
                                }


                        %>



                    </tbody>


                </table>
            </div>


        </form>

        <div id="volver">
            <a href="ProfesorController?accion=volverAlumno">Volver</a>

        </div>



    </body>
</html>
