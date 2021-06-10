<%-- 
    Document   : nuevaUniversidad
    Created on : 05-jun-2021, 19:40:25
    Author     : Javier
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Universidad_Destino"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>INSERTAR UNIVERSIDAD</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>INSERTAR UNIVERSIDAD</title>
    </head>
    <body>


        <form action="ProfesorController?accion=insertarUniversidad" method="POST" autocomplete="off">


            <div>


            <div id="form10">
                <h1>NUEVA UNIVERSIDAD</h1>
                    <label>Codigo Universidad</label>
                    <input id="CodigoU" class="form-control" name="CodigoU" type="text" align="left"/>
                    <label>Nombre Universidad</label>
                    <input type="text" class="form-control" name="NombreU" id="NombreU" placeholder="">
                    <label>Pais</label>
                    <input type="text" class="form-control" name="Pais" id="Pais" placeholder="">
                    <label>Ciudad</label>
                    <input type="text" class="form-control" name="Ciudad" id="Ciudad" placeholder="">


                </div>


                <br>

                <br><br><br>
            </div>
            <div id="butInsertarUniversidad">


                <button  id="insertarUniversidad" class="btn btn-primary" name="insertarUniversidad" type="submit" >Insertar</button>
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
            alert('No se ha podido dar de alta la universidad');
        </script><%}%>
        <%if (mensaje == "correcto") {%>
        <script>
            alert('Universidad dada de alta correctamente');
        </script><%}%>



    </body>
</html>

