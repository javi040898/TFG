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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
    </head>
    <body>


        <form action="ProfesorController?accion=insertarAlumno" method="POST" autocomplete="off">
            <div id="form10">
                <h1>ALTA ALUMNO</h1>
                <p>


                    <label>Contraseña</label>
                    <input id="PasswA" class="form-control" name="Password" type="Password" align="left"/>
                </p>
                <p>


                    <label>Nombre</label>
                    <input id="Nombre" class="form-control" name="Nombre" type="text" align="left"/>
                </p>

                <p>


                    <label>Apellidos</label>
                    <input id="Apellidos" class="form-control" name="Apellidos" type="text" align="left"/>
                </p>

                <p>


                    <label>Nombre Usuario</label>
                    <input id="Nombre_usuario" class="form-control" name="Nombre_usuario" type="text" align="left"/>
                </p>

                <p>


                    <label>DNI</label>
                    <input id="DNI_Alumno" class="form-control" name="DNI_Alumno" type="text" align="left"/>
                </p>
            </div>
            <div id="butAlta">
                <button  id="Alta" name="Alta" type="submit">Alta</button>
            </div>



        </form>
    </body>
</html>
