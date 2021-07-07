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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      <title>BUSCADOR DE CONVALIDACIONES</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <style>
            body{
                background:#F5F5F5;
            }
            #titulo2{

                float:left;
                left:1000px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:260px;
                position:absolute;



            }
            .div06{
                position:absolute;

                display:block;

                font-size:35px;

                left:500px;

            }
            #tituloModificar{

                float:left;
                left:30px;
                margin:60px;
                top:150px;
                position:relative;
                font-size: xx-large;



            }
            
            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }
            
            #table2 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -70px;


            }
            #table2 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                background:#EDE6E2;
                padding: 0.3em;
            }
            #butBuscador{

                position:absolute;

                display:block;



                left:825px;
                top:175px;

                background:#0CF;

            }
            #form5 {
                float:left;

                margin:50px;
                padding:10px;
                position:relative;
                top:30px;
                left: 600px;
            }

            #tituloCancelar{

                float:left;
                left:0px;
                margin:60px;
                top:60px;
                position:relative;
                font-size: xx-large;


            }



            #titulo3{

                float:left;
                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:200px;
                position:absolute;
                left:20px;


            }

            #titulo4{

                float:left;
                left:750px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:200px;
                position:absolute;



            }
        </style>
        <title>BUSCADOR DE CONVALIDACION</title>
    </head>
    <body>
        <div class="div06">BUSCADOR DE CONVALIDACIONES EN CURSOS ANTERIORES</div>


        <form action="PropuestaLA?accion=buscadorConvalidacion" method="POST" autocomplete="off">



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

                            if (listaRA != null)
                                for (RelacionAsignaturas ra : listaRA) {

                        %>
                        <tr>



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


        </form>

        <div id="volver">
            <a href="PropuestaLA?accion=volverAlumno">Volver</a>

        </div>



    </body>
</html>
