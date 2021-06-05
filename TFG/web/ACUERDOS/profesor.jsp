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
            <%  String nombre = "";
                if (String.valueOf(request.getAttribute("nombreAlumno")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("nombreAlumno")));
                    nombre = String.valueOf(request.getAttribute("nombreAlumno"));
                }

                String apellidos = "";
                if (String.valueOf(request.getAttribute("apellidosAlumno")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("nombreAlumno")));
                    apellidos = String.valueOf(request.getAttribute("apellidosAlumno"));
                }
            %>    
            <%
                String codigoGrado = "";
                if (String.valueOf(request.getAttribute("codigoGrado")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("codigoGrado")));
                    codigoGrado = String.valueOf(request.getAttribute("codigoGrado"));
                }
            %>   

            <%
                String nombreGrado = "";
                if (String.valueOf(request.getAttribute("nombreGrado")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("nombreGrado")));
                    nombreGrado = String.valueOf(request.getAttribute("nombreGrado"));
                }
            %>  

            <%
                String facultad = "";
                if (String.valueOf(request.getAttribute("facultad")) != "null") {
                    System.out.println(String.valueOf(request.getAttribute("facultad")));
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
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosOrigen")));
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
                                    System.out.println(String.valueOf(request.getAttribute("sumaCreditosDestino")));
                                    sumaCreditosDestino = String.valueOf(request.getAttribute("sumaCreditosDestino"));
                                }
                            %> 
                            <th>Total creditos aceptados en la Universidad de Destino: <%=sumaCreditosDestino%></th>
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
                <div id="comentariosModificada"> <label>Comentarios</label>
                    <input id="ComentariosModificada" class="form-control" name="ComentariosModificada" type="textarea" align="left" size="50"/></div>

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

                        
                        
                        
            <div id="tituloCancelar">  <h1 >CANCELAR ASIGNATURA</h1></div>
            <div id="form11">
                <select class="form-control" id="listaAsignaturasCancelar" name="listaAsignaturasCancelar">
                    <option>Escoge una asignatura</option>
                    <% if (listaRA != null)
                            for (RelacionAsignaturas ra : listaRA) {
                                if (ra.getEstado().equals("Aceptada")) {
                    %>
                    <option value="<%=ra.getCodigo_destino()%>"><%=ra.getNombre_destino()%><%=" (" + ra.getCodigo_destino() + ")"%></option>
                    <% }
                        }%>





                </select>
            </div>
            <div id="comentariosCancelada">
             <div id="label1"    <label>Comentarios</label></div>
                <input id="comentariosCancelada" class="form-control" name="ComentariosCancelada" type="textarea" align="left" size="40"/></div>



            <div id="butCancelar">
                <button>Cancelar</button>
            </div>






        </form>

        <br>
        <br><br><br>
        <div id="enlaceNuevo">
            <a href="ProfesorController?accion=nuevoAlumno">Dar de alta a alumno</a>
            <br>
            <a href="ProfesorController?accion=nuevaEstancia">Nueva estancia de alumno</a>
            <br>
            <a href="ProfesorController?accion=nuevaUniversidad">Nueva universidad de destino</a>
            <br>
            <a href="ProfesorController?accion=nuevoGrado">Nuevo grado</a>
        </div>


















    </body>
</html>
