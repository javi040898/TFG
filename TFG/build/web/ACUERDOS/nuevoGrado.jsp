<%-- 
    Document   : nuevoGrado
    Created on : 05-jun-2021, 19:57:38
    Author     : Javier
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Universidad_Destino"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>INSERTAR GRADO</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>INSERTAR GRADO</title>
    </head>
    <body>


        <form action="ProfesorController?accion=insertarGrado" method="POST" autocomplete="off">


            <div>

            <div id="form10">
                <h1>NUEVO GRADO</h1>
                    <label>Codigo Grado</label>
                    <input id="CodigoG" class="form-control" name="CodigoG" type="text" align="left"/>
                    <label>Nombre Grado</label>
                    <input type="text" class="form-control" name="NombreG" id="NombreG" placeholder="">
                    <label>Facultad</label>
                    <input type="text" class="form-control" name="FacultadG" id="FacultadG" placeholder="">


                </div>


                <br>

                <br><br><br>
            </div>
            <div id="butInsertarGrado">


                <button  id="insertarGrado" class="btn btn-primary" name="insertarGrado" type="submit" >Insertar</button>
            </div>


        </form>


        <div id="volver">
            <a href="ProfesorController?accion=volverProfesor">Volver</a>

        </div>
        
        <%
            String mensaje = (String) request.getAttribute("confirmacion");
            System.out.println("mensaje: " + mensaje);
     if (mensaje == "error") {%>
        <script>
            alert('No se ha podido dar de alta el grado');
        </script><%}%>
        <%if (mensaje == "correcto") {%>
        <script>
            alert('Grado dado de alta correctamente');
        </script><%}%>



    </body>
</html>


