<%-- 
    Document   : nuevo
    Created on : 09-feb-2021, 18:49:18
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo</h1>
        <br/><br/>
        <form action="" method="POST" autocomplete="off">
            
            <p>
                Usuario:
                <input id="usuario" name="usuario" type="text" />
                
            </p>
            <p>
                Contraseña
                <input id="password" name="password" type="text" />
                
            </p>
            <p>
                Nombre
                <input id="nombre" name="nombre" type="text" />
                
            </p>
            <p>
                Apellidos:
                <input id="apellidos" name="apellidos" type="text" />
                
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
                
            
        </form>
        
        
    </body>
</html>
