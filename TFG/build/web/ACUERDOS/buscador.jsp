<%-- 
    Document   : buscador
    Created on : 01-abr-2021, 17:54:10
    Author     : Javier
--%>

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
                background:#3C82B6;
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


                    <div id="titulo3"> <h1>ASIGNATURAS ORIGEN 
                        </h1></div>
                    <div id="titulo4"> <h1>ASIGNATURAS DESTINO 
                        </h1></div>



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

                        <% List<Asignatura_Origen> listaAsignaturasOrigen = (List<Asignatura_Origen>) request.getAttribute("listaAsignaturasOrigenBuscador");
                            /*for (int i = 0; i < listaAsignaturasOrigen.size(); i++) {
                                System.out.println(listaAsignaturasOrigen.get(i).getNombre());
                            }*/

                            List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestinoBuscador");
                            if (listaAsignaturasOrigen != null && listaAsignaturasDestino != null)
                                for (Asignatura_Origen asignaturaO : listaAsignaturasOrigen) {
                                    for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                                        if (String.valueOf(asignaturaO.getCodigo()).equals(String.valueOf(asignaturaD.getCodigo_Asignatura_Origen()))) {
                                            //System.out.println(asignaturaO.getNombre());
%>
                        <tr>

                            <td><%=asignaturaO.getCodigo()%></td>
                            <td><%=asignaturaO.getCreditos()%></td>
                            <td><%=asignaturaO.getNombre()%></td>
                            <td><%=asignaturaO.getGuia_docente()%></td>
                            <td><a href="<%=asignaturaO.getGuia_docente()%>" > link</a></td>


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


        </form>



    </body>
</html>
