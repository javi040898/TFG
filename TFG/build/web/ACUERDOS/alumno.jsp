<%-- 
    Document   : alumno
    Created on : 02-feb-2021, 19:25:51
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <style>
            body{
                background:#F5F5F5;
            }
        </style>

        <div class="div07">ALUMNO</div>
        <form action="PropuestaLA?accion=listarAsignaturas" method="POST" autocomplete="off">
            <%
                String DNI = request.getAttribute("DNI_A").toString();

            %>

        </form>

        <div id="enlacesAlumno">
            <a href="PropuestaLA?accion=nuevasAsignaturasOrigenAlumno">Nueva asignatura origen</a>
            <br>
            <br>
            <a href="PropuestaLA?accion=nuevasAsignaturasDestinoAlumno">Nueva asignatura destino</a>
            <br>
            <br>
            <a href="PropuestaLA?accion=nuevaConvalidacion">Nueva convalidacion</a>
            <br>
            <br>
            <a href="PropuestaLA?accion=buscarConvalidacion">Buscar antiguas convalidaciones</a>
            <br>
            <br>
            <a href="PropuestaLA?accion=verConvalidacionesActuales">Estado convalidaciones actuales</a>
            <br>
            <br>
            <a href="PropuestaLA?accion=cambiarPasswordAlumno">Cambiar contraseña</a>
        </div>

        <div id="volver">
            <a href="PropuestaLA?accion=volverLogin">Volver</a>

        </div>
    </body>
</html>
