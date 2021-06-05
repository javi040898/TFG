<%-- 
    Document   : nuevaConvalidacion
    Created on : 02-jun-2021, 9:58:48
    Author     : Javier
--%>

<%@page import="modelo.Asignatura_Destino"%>
<%@page import="modelo.Asignatura_Origen"%>
<%@page import="modelo.Asignatura_OrigenDAO"%>
<%@page import="modelo.Universidad_DestinoDAO"%>
<%@page import="modelo.Estancia"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Universidad_Destino"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>CONVALIDACION</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>CONVALIDACION</title>
    </head>
    <body>
        <div class="div08">CONVALIDACION</div>


        <form action="ProfesorController?accion=insertarConvalidacion" method="POST" autocomplete="off">
            <div>

                <div id="form12">

                    <select class="form-control" id="listaEstancias" name="listaEstancias">

                        <option>Escoge la estancia donde se va a realizar la convalidacion</option>
                        <%
                            Universidad_DestinoDAO universidadDAO = new Universidad_DestinoDAO();
                            List<Estancia> listaEstancias = (List<Estancia>) request.getAttribute("listaEstancias");
                            if (listaEstancias != null)
                                for (Estancia estancia : listaEstancias) {%>
                        <option value="<%=estancia.getId_estancia()%>"><%=estancia.getCurso_academico()%><%=" ("
                                + universidadDAO.obtenerNombre(estancia.getCodigo_erasmus_Universidad_destino()) + " )"%></option>
                            <% }%>





                    </select>

                </div>

                <div id="form13">

                    <select class="form-control" id="listaEstancias" name="listaOrigen">

                        <option>Escoge asignatura origen</option>
                        <%

                            List<Asignatura_Origen> listaAsignaturasOrigen = (List<Asignatura_Origen>) request.getAttribute("listaAsignaturasOrigen");
                            if (listaAsignaturasOrigen != null)
                                for (Asignatura_Origen asignatura_origen : listaAsignaturasOrigen) {%>
                        <option value="<%=asignatura_origen.getCodigo()%>"><%=asignatura_origen.getNombre()%><%=" ("
                                + asignatura_origen.getCodigo() + " )"%></option>
                            <% }%>





                    </select>

                </div>
                <div id="form14">

                    <select class="form-control" id="listaEstancias" name="listaDestino">

                        <option>Escoge asignatura destino</option>
                        <%

                            List<Asignatura_Destino> listaAsignaturasDestino = (List<Asignatura_Destino>) request.getAttribute("listaAsignaturasDestino");
                            if (listaAsignaturasDestino != null)
                                for (Asignatura_Destino asignatura_destino : listaAsignaturasDestino) {%>
                        <option value="<%=asignatura_destino.getCodigo()%>"><%=asignatura_destino.getNombre()%><%=" ("
                                + asignatura_destino.getCodigo() + " )"%></option>
                            <% }%>





                    </select>

                </div>


            </div>
            <div id="butAceptarConvalidacion">


                <button  id="AceptarConvalidacion" class="btn btn-primary" name="AceptarConvalidacion" type="submit" >Seleccionar</button>
            </div>


        </form>



    </body>
</html>