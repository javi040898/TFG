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
        <title>JSP Page</title>
    </head>
    <body>

        <div class="div07">ALUMNO</div>
        <form action="ProfesorController?accion=listarAsignaturas" method="POST" autocomplete="off">
            <%
                String DNI = request.getAttribute("DNI_A").toString();

            %>

        </form>

        <div id="enlacesAlumno">
            <a href="ProfesorController?accion=nuevasAsignaturasOrigen">Nueva asignatura origen</a>
            <br>
            <a href="ProfesorController?accion=nuevasAsignaturasDestino">Nueva asignatura destino</a>
            <br>
            <a href="ProfesorController?accion=nuevaConvalidacion">Nueva convalidacion</a>
            <br>
            <a href="ProfesorController?accion=buscarConvalidacion">Buscar antiguas convalidaciones</a>
            <br>
            <a href="ProfesorController?accion=convalidacionesActuales">Estado convalidaciones actuales</a>
            <br>
            <a href="ProfesorController?accion=cambiarPassword">Cambiar contraseña</a>
        </div>
    </body>
</html>
