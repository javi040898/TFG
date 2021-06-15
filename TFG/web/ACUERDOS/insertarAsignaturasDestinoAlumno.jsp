<%-- 
    Document   : insertarAsignaturaDestino
    Created on : 05-jun-2021, 17:36:51
    Author     : Javier
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Universidad_Destino"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>INSERTAR ASIGNATURAS</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>INSERTAR ASIGNATURAS</title>
    </head>
    <body>


        <form action="PropuestaLA?accion=insertarAsignaturasDestino" method="POST" autocomplete="off">


            <div>


                <div id="form2">
                    <h1>NUEVA ASIGNATURA DESTINO</h1>
                    <label>Codigo Asignatura</label>
                    <input id="CodigoD1" class="form-control" name="CodigoD" type="text" align="left"/>
                    <label>Nombre Asignatura</label>
                    <input type="text" class="form-control" name="NombreD" id="NombreD1" placeholder="">
                    <label>Creditos</label>
                    <input type="text" class="form-control" name="CreditosD" id="CreditosD1" placeholder="">
                    <label>Informacion</label>
                    <input type="text" class="form-control" name="InformacionD" id="InformacionD1" placeholder="">
                    <label>Universidad</label>

                    <select class="form-control" id="listaUniversidadesDsetino" name="listaUniversidadesDsetino">

                        <option>Escoge una universidad</option>
                        <%

                            List<Universidad_Destino> listaUniversidades = (List<Universidad_Destino>) request.getAttribute("listaUniversidades");
                            if (listaUniversidades != null)
                                for (Universidad_Destino universidad : listaUniversidades) {%>
                        <option value="<%=universidad.getCodigo_erasmus()%>"><%=universidad.getNombre()%><%=" (" + universidad.getCiudad() + " )"%></option>
                        <% }%>





                    </select>

                </div>


                <br>

                <br><br><br>
            </div>
            <div id="butInsertarAsignaturasDestino">


                <button  id="insertarAsignaturas" class="btn btn-primary" name="insertarAsignaturas" type="submit" >Insertar</button>
            </div>


        </form>
        <div id="volver">
            <a href="PropuestaLA?accion=volverAlumno">Volver</a>

        </div>

        <%
            String mensaje = (String) request.getAttribute("confirmacion");
            System.out.println("mensaje: " + mensaje);
     if (mensaje == "error") {%>
        <script>
            alert('No se ha podido dar de alta la asignatura');
        </script><%}%>
        <%if (mensaje == "correcto") {%>
        <script>
            alert('Asignatura insertada correctamente');
        </script><%}%>




    </body>
</html>

