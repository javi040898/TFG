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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     <title>CONVALIDACIONES ACTUALES</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
           


            #titulo5{

                float:left;
                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:175px;
                position:absolute;
                left:20px;


            }

            #titulo6{

                float:left;
                left:800px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:175px;
                position:absolute;



            }
         

            #form17{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:50px;
                right:-600px;

            }

           

            #butConfirmarEstancia{

                position:absolute;

                display:block;



                left:515px;
                top:42px;

            }

            


            

            #table6 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -150px;

            }
            #table6 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }



            #table7 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -150px;

            }
            #table7 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }

            #table4 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -130px;

            }
            #table4 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                background:#EDE6E2;
                padding: 0.3em;
            }


            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }

            .div06{
                position:absolute;

                display:block;

                font-size:35px;

                left:500px;

            }

            
        </style>
        <title>CONVALIDACIONES ACTUALES</title>
    </head>
    <body>
        <div class="div06">VER CONVALIDACIONES ACTUALES</div>



        <form action="PropuestaLA?accion=convalidacionesActuales" method="POST" autocomplete="off">

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




                    <th>Convalidacion</th>
                    <th>Codigo</th>
                    <th>Nombre Asignatura</th>
                    <th>Tipo</th>
                    <th>Creditos</th>


                    <th>Link asignatura</th>


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

                            if (listaRA != null)
                                for (RelacionAsignaturas ra : listaRA) {

                        %>
                        <tr>


                            <td><%=ra.getId_convalidacion()%></td>
                            <td><%=ra.getCodigo_origen()%></td>
                            <td><%=ra.getNombre_origen()%></td>
                            <td><%=ra.getTipo()%></td>
                            <td><%=ra.getCreditos_origen()%></td>
                            <td><a href="<%=ra.getInformacion_origen()%>" target="_blank" > link</a></td>


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
            <a href="PropuestaLA?accion=volverAlumno">Volver</a>

        </div>






    </body>
</html>
