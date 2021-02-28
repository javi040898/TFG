<%-- 
    Document   : altaAlumno
    Created on : 28-feb-2021, 17:32:32
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>ALTA ALUMNO</title>
    </head>
    <body>
        <h1>ALTA ALUMNO</h1>
        
        <form action="ProfesorController?accion=insertarAlumno" method="POST" autocomplete="off">
            
            <p>
                
                Contraseña:
                <input id="Password" name="Password" type="password" align="center"/> 
            </p>
            <p>
                
                Nombre:
                <input id="Nombre" name="Nombre" type="text" /> 
            </p>
            
            <p>
                
                Apellidos:
                <input id="Apellidos" name="Apellidos" type="text" /> 
            </p>
            
            <p>
                
                Nombre Usuario:
                <input id="Nombre_usuario" name="Nombre_usuario" type="text" /> 
            </p>
            
            <p>
                
                DNI:
                <input id="DNI_Alumno" name="DNI_Alumno" type="text" /> 
            </p>
            
            <button  id="Alta" name="Alta" type="submit">Alta</button>
            
            
            
            
        </form>
    </body>
</html>
