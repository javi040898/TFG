<%-- 
    Document   : profesor
    Created on : 17-ene-2021, 19:35:12
    Author     : Javier
--%>

<%@page import="modelo.EstanciaDAO"%>
<%@page import="modelo.Universidad_DestinoDAO"%>
<%@page import="modelo.Estancia"%>
<%@page import="modelo.RelacionAsignaturas"%>
<%@page import="modelo.Asignatura_Destino"%>
<%@page import="modelo.Asignatura_Origen"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      <title>PROFESOR</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <style>
            body{
                background:#F5F5F5;
            }


            #titulo1{

                float:left;
                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:260px;
                position:absolute;
                left:20px;


            }

            #titulo2{

                float:left;
                left:750px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:260px;
                position:absolute;



            }
            #tituloModificar{

                float:left;
                left:30px;
                margin:60px;
                top:150px;
                position:relative;
                font-size: xx-large;



            }

            #tituloCancelar{

                float:left;
                left:0px;
                margin:60px;
                top:60px;
                position:relative;
                font-size: xx-large;


            }





            #NombreAlumno{

                float:left;
                left:1370px;

                margin:20px;
                padding:10px;
                top:0px;
                position:absolute;
                color: #050404



            }

            #ApellidosAlumno{

                float:left;
                left:1370px;

                margin:20px;
                padding:10px;
                top:20px;
                position:absolute;
                color: #050404



            }
            #CodigoGrado{

                float:left;
                left:1370px;

                margin:20px;
                padding:10px;
                top:40px;
                position:absolute;
                color: #050404



            }
            #NombreGrado{

                float:left;
                left:1370px;

                margin:20px;
                padding:10px;
                top:60px;
                position:absolute;
                color: #050404;



            }
            #Facultad{

                float:left;
                left:1370px;

                margin:20px;
                padding:10px;
                top:80px;
                position:absolute;
                color: #050404;




            }






            #comentariosModificada {
                float:left;

                margin:15px;
                position:relative;
                top:0px;
                left: -15px;

            }

            #comentariosCancelada {
                float:left;

                margin:15px;
                position:relative;
                top:0px;
                left: -15px;

            }
            #label1 {
                float:left;

                margin:15px;
                position:relative;
                top:42px;
                left: 925px;

            }



            #form7 {
                float:left;

                margin:25px;
                position:relative;
                top:250px;
                right:580px;


            }

            #form11 {
                float:left;

                margin:25px;
                position:relative;
                top:-15px;
                right:-1196px;

            }




            #form8 {
                float:left;

                margin:25px;
                position:relative;
                top:250px;
                right:560px;

            }



            #form20{

                float:left;

                margin:25px;
                position:absolute;
                top:1500px;
                right:560px;


            }

            #form10 {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                left:600px;


            }
            #form6 {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:2px;
                left: 475px;

            }


            #butAceptar{
                float:left;

                margin:25px;
                padding:10px;
                position:absolute;

                display:block;



                left:1250px;
                top:20px;



            }

            #butModificar{

                float:left;

                margin:25px;
                position:relative;
                top:252px;
                right:565px;

            }
            #butCancelar{

                float:left;

                margin:25px;
                position:relative;
                top:-12px;
                right:-1190px;

            }


            #enlaceNuevo{

                position:absolute;

                display:block;



                left:250px;
                top:20px;



            }




            #table1 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -200px;

            }
            #table1 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                background:#EDE6E2;
                padding: 0.3em;
            }


            #table3 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -195px;

            }
            #table3 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }



            #table5 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -195px;

            }
            #table5 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }




            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }




        </style>
    </head>
    <body>




        <form action="PropuestaLA?accion=listarAlumnos" method="POST" autocomplete="off">
            <p align="center"> 
            <div id="form6">
                <select class="form-control" id="listaEstanciasAlumnos" name="listaEstanciasAlumnos">



                    <option>Escoge una estancia y alumno</option>
                    <%
                        Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
                        EstanciaDAO estanciaDAO = new EstanciaDAO();
                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        List<Estancia> listaEstancias = (List<Estancia>) request.getAttribute("listaEstancias");

                        if (listaAlumnos != null)
                            if (listaEstancias != null)
                                for (Estancia estancia : listaEstancias) {
                                    String cerrada = "EN PROGRESO";
                                    for (Alumno alumno : listaAlumnos) {

                                        if (alumno.getDNI().equals(estancia.getDNI_alumno())) {
                                            if (estanciaDAO.obtenerRenuncia(estancia.getId_estancia())) {
                                                cerrada = "RENUNCIADA";
                                            } else {
                                                if (estanciaDAO.obtenerCerrada(estancia.getId_estancia())) {
                                                    cerrada = "CERRADA";
                                                }
                                            }


                    %>
                    <option value="<%=estancia.getId_estancia()%>"><%=estancia.getTipo() + " "%><%=universidadDAO.obtenerNombre(estancia.getCodigo_erasmus_Universidad_destino())%><%=" ("
                            + estancia.getCurso_academico() + ") "%><%=alumno.getNombre()%><%=" " + alumno.getApellidos()%><%=" (" + alumno.getDNI() + ") "%><%=cerrada%>
                    </option>
                    <%
                                    break;
                                }

                            }
                        }%>





                </select>


            </div>

            <%  String nombre = "";
                if (String.valueOf(request.getAttribute("nombreAlumno")) != "null") {
                    nombre = String.valueOf(request.getAttribute("nombreAlumno"));
                }

                String apellidos = "";
                if (String.valueOf(request.getAttribute("apellidosAlumno")) != "null") {
                    apellidos = String.valueOf(request.getAttribute("apellidosAlumno"));
                }
            %>    
            <%
                String codigoGrado = "";
                if (String.valueOf(request.getAttribute("codigoGrado")) != "null") {
                    codigoGrado = String.valueOf(request.getAttribute("codigoGrado"));
                }
            %>   

            <%
                String nombreGrado = "";
                if (String.valueOf(request.getAttribute("nombreGrado")) != "null") {
                    nombreGrado = String.valueOf(request.getAttribute("nombreGrado"));
                }
            %>  

            <%
                String facultad = "";
                if (String.valueOf(request.getAttribute("facultad")) != "null") {
                    facultad = String.valueOf(request.getAttribute("facultad"));
                }
            %> 

            <div id="NombreAlumno">Nombre: <%=nombre%>
            </div>

            <div id="ApellidosAlumno">Apellidos: <%=apellidos%>
            </div>

            <div id="CodigoGrado">Codigo Grado: <%=codigoGrado%>
            </div>

            <div id="NombreGrado" color="#0CF">Nombre Grado: <%=nombreGrado%>
            </div>

            <div id="Facultad">Facultad: <%=facultad%>
            </div>
            <div id="table1">
                <table>
                    <thead>

                        <tr>
                    <div id="titulo1"> ASIGNATURAS A RECONOCER EN LA UNIVERSIDAD DE ALCALÁ
                    </div>
                    <div id="titulo2"> ASIGNATURAS CURSADAS  EN LA UNIVERSIDAD DE DESTINO
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

                        <% List<RelacionAsignaturas> listaRA = (List<RelacionAsignaturas>) request.getAttribute("listaRA");

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
                            // }

                            // }%>



                    </tbody>


                </table>
            </div>

            <div id="table3">
                <table>
                    <thead>
                        <tr>
                            <%
                                String sumaCreditosOrigen = "";
                                if (String.valueOf(request.getAttribute("sumaCreditosOrigen")) != "null") {
                                    sumaCreditosOrigen = String.valueOf(request.getAttribute("sumaCreditosOrigen"));
                                }
                            %> 
                            <th>Total creditos aceptados en la Universidad de Alcalá: <%=sumaCreditosOrigen%></th>
                        </tr>
                    </thead>

                </table>
            </div>

            <div id="table5">
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
            <div id="butAceptar">
                <button>Aceptar</button>
            </div>
        </form>


        <form action="PropuestaLA?accion=modificarAsignatura" method="POST" autocomplete="off">



            <div id="tituloModificar">  <h1 >MODIFICAR CONVALIDACION</h1></div>
            <div id="form7">

                <select class="form-control" id="listaAsignaturasModificar" name="listaAsignaturasModificar" action="modificar" >
                    
                    <option>Escoge una convalidacion</option>

                    <%  List<RelacionAsignaturas> listaRAPosibles = (List<RelacionAsignaturas>) request.getAttribute("listaRAPosibles");
                        if (listaRAPosibles != null)
                            for (RelacionAsignaturas ra : listaRAPosibles) {
                                if (ra.getEstado().equals("PENDIENTE")) {
                    %>
                    <option value="<%=ra.getId_convalidacion()%>"><%="Convalidacion Nº " %><%=ra.getId_convalidacion()%></option>
                    <% }
                        }%>





                </select>

                <div id="comentariosModificada"> <label>Comentarios</label>
                    <input id="ComentariosModificada" class="form-control" name="ComentariosModificada" type="textarea" align="left" size="50"/></div>

            </div>

            <div id="form8">

                <select class="form-control" id="modificarEstado" name="modificarEstado">
                    <option>Escoge un estado</option>
                    <option>ACEPTAR</option>
                    <option>RECHAZAR</option>
                </select>
            </div>
            <div id="butModificar">
                <button>Modificar</button>
            </div>
        </form>





        <form action="PropuestaLA?accion=cancelarAsignatura" method="POST" autocomplete="off">
            <div id="tituloCancelar">  <h1 >CANCELAR CONVALIDACION</h1></div>
            <div id="form11">
                <select class="form-control" id="listaAsignaturasCancelar" name="listaAsignaturasCancelar">
                    <option>Escoge una convalidacion</option>
                    <% if (listaRAPosibles != null)
                            for (RelacionAsignaturas ra : listaRAPosibles) {
                                if (ra.getEstado().equals("ACEPTADA")) {
                    %>
                    <option value="<%=ra.getId_convalidacion()%>"><%="Convalidacion Nº " %><%=ra.getId_convalidacion()%></option>
                    <% }
                        }%>

                </select>

                <div id="comentariosCancelada">
                    <label>Comentarios</label>
                    <input id="comentariosCancelada" class="form-control" name="ComentariosCancelada" type="textarea" align="left" size="40"/></div>
            </div>





            <div id="butCancelar">
                <button>Cancelar</button>
            </div>
        </form>

        <div id="form20">  <br></div>


        <br>
        <br><br><br>
        <div id="enlaceNuevo">
            <a href="PropuestaLA?accion=nuevoAlumno">Dar de alta a alumno</a>
            <br>
            <a href="PropuestaLA?accion=nuevaEstancia">Nueva estancia de alumno</a>
            <br>
            <a href="PropuestaLA?accion=nuevoProfesor">Dar de alta a profesor</a>
            <br>
            <a href="PropuestaLA?accion=nuevaUniversidad">Nueva universidad de destino</a>
            <br>
            <a href="PropuestaLA?accion=nuevoGrado">Nuevo grado</a>
            <br>
            <a href="PropuestaLA?accion=renunciaAlumno">Renuncia alumno</a>
            <br>
            <a href="PropuestaLA?accion=cerrarEstancia">Cerrar estancia</a>
            <br>
            <a href="PropuestaLA?accion=nuevasAsignaturasOrigenProfesor">Nueva asignatura origen</a>
            <br>
            <a href="PropuestaLA?accion=nuevasAsignaturasDestinoProfesor">Nueva asignatura destino</a>
            <br>
            <a href="PropuestaLA?accion=cambiarPasswordProfesor">Cambiar contraseña</a>

        </div>

        <div id="volver">
            <a href="PropuestaLA?accion=volverLogin">Volver</a>

        </div>



    </body>
</html>
