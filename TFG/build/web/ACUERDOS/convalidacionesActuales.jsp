<%-- 
    Document   : convalidacionesActuales
    Created on : 23-may-2021, 11:29:53
    Author     : Javier
--%>

<%@page import="modelo.Estancia"%>
<%@page import="modelo.Universidad_DestinoDAO"%>
<%@page import="modelo.RelacionAsignaturas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>CONVALIDACIONES ACTUALES</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>CONVALIDACIONES ACTUALES</title>
    </head>
    <body>
        <div class="div06">VER CONVALIDACIONES ACTUALES</div>


        <form action="ProfesorController?accion=convalidacionesActuales" method="POST" autocomplete="off">

            <div id="form17">

                <select class="form-control" id="listaEstancias" name="listaEstancias">

                    <option>Escoge la estancia que deseas comprobar</option>
                    <%
                        Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
                        List<Estancia> listaEstancias = (List<Estancia>) request.getAttribute("listaEstancias");
                        if (listaEstancias != null)
                            for (Estancia estancia : listaEstancias) {%>
                    <option value="<%=estancia.getId_estancia()%>"><%=estancia.getTipo() + " "%><%=universidadDAO.obtenerNombre(estancia.getCodigo_erasmus_Universidad_destino())%><%=" ("
                                + estancia.getCurso_academico() + ")"%></option>
                        <% }%>





                </select>

            </div>
            <div id="butConfirmarEstancia">


                <button  id="butConfirmarEstancia" class="btn btn-primary" name="butConfirmarEstancia" type="submit" >Seleccionar</button>
            </div>

            <div id="table4">
                <table>
                    <thead>

                        <tr>


                    <div id="titulo5"> ASIGNATURAS RECONOCIDAS EN LA UNIVERSIDAD DE ALCALÁ
                    </div>
                    <div id="titulo6"> ASIGNATURAS CURSADAS  EN LA UNIVERSIDAD DE DESTINO
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

                        <% List<RelacionAsignaturas> listaRA = (List<RelacionAsignaturas>) request.getAttribute("listaRelacionAsignaturasConvalidacionesActuales");
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

            <div id="table6">
                <table>
                    <thead>
                        <tr>
                            <%                                String sumaCreditosOrigen = "";
                                if (String.valueOf(request.getAttribute("sumaCreditosOrigen")) != "null") {
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosOrigen")));
                                    sumaCreditosOrigen = String.valueOf(request.getAttribute("sumaCreditosOrigen"));
                                }
                            %> 
                            <th>Total creditos aceptados en la Universidad de Alcalá: <%=sumaCreditosOrigen%></th>
                        </tr>
                    </thead>

                </table>
            </div>

            <div id="table7">
                <table>
                    <thead>
                        <tr>
                            <%
                                String sumaCreditosDestino = "";
                                if (String.valueOf(request.getAttribute("sumaCreditosDestino")) != "null") {
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosDestino")));
                                    sumaCreditosDestino = String.valueOf(request.getAttribute("sumaCreditosDestino"));
                                }
                            %> 
                            <th>Total creditos aceptados en la Universidad de Destino: <%=sumaCreditosDestino%></th>
                        </tr>
                    </thead>

                </table>
            </div>


        </form>
        <div id="volver">
            <a href="ProfesorController?accion=volverAlumno">Volver</a>

        </div>






    </body>
</html>
