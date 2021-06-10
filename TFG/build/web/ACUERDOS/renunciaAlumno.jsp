<%-- 
    Document   : renunciaAlumno
    Created on : 08-jun-2021, 12:45:04
    Author     : Javier
--%>

<%@page import="modelo.Estancia"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Universidad_DestinoDAO"%>
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




        <form action="ProfesorController?accion=listarAlumnosRenuncia" method="POST" autocomplete="off">
            <p align="center"> 
            <div id="form6">

                <h1>NUEVA RENUNCIA</h1>

                <select class="form-control" id="listaEstanciasAlumnosRenuncia" name="listaEstanciasAlumnosRenuncia">



                    <option>Escoge una estancia y alumno</option>
                    <%
                        Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnos");
                        List<Estancia> listaEstancias = (List<Estancia>) request.getAttribute("listaEstancias");

                        if (listaAlumnos != null)
                            if (listaEstancias != null)
                                for (Estancia estancia : listaEstancias) {
                                    for (Alumno alumno : listaAlumnos) {

                                        System.out.println("DNI1:" + alumno.getDNI() + " DNI2:" + estancia.getDNI_alumno());
                                        if (alumno.getDNI().equals(estancia.getDNI_alumno())) {


                    %>
                        <option value="<%=estancia.getId_estancia()%>"><%=estancia.getTipo() + " "%><%=universidadDAO.obtenerNombre(estancia.getCodigo_erasmus_Universidad_destino())%><%=" ("
                            + estancia.getCurso_academico() + ") "%><%=alumno.getNombre()%><%=" " + alumno.getApellidos()%><%=" (" + alumno.getDNI() + ") "%></option>
                        <%
                                        break;
                                    }

                                }
                            }%>





                </select>


            </div>

            <div id="butAceptarRenuncia">
                <button>Aceptar</button>
            </div>

        </form>

        <div id="volver">
            <a href="ProfesorController?accion=volverProfesor">Volver</a>

        </div>




















    </body>
</html>

