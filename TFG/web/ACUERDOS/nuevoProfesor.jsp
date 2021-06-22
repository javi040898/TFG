<%-- 
    Document   : nuevoProfesor
    Created on : 10-jun-2021, 19:07:59
    Author     : Javier
--%>

<%@page import="modelo.Universidad_Destino"%>
<%@page import="modelo.Grado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  <title>NUEVO PROFESOR</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;

            }

            #form10 {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                left:600px;


            }


            #butAltaProfesor{

                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:580px;
                left:350px;

            }



            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }

        </style>
    </head>
    <body>


        <form action="PropuestaLA?accion=insertarProfesor" method="POST" autocomplete="off">
            <div id="form10">
                <h1>NUEVO PROFESOR</h1>

                <p>


                    <label>Nombre</label>
                    <input id="Nombre" class="form-control" name="Nombre" type="text" align="left"/>
                </p>

                <p>


                    <label>Apellidos</label>
                    <input id="Apellidos" class="form-control" name="Apellidos" type="text" align="left"/>
                </p>
                <p>


                    <label>Contraseña</label>
                    <input id="PasswA" class="form-control" name="Password" type="Password" align="left"/>
                </p>

                <p>


                    <label>Nombre Usuario</label>
                    <input id="Nombre_usuario" class="form-control" name="Nombre_usuario" type="text" align="left"/>
                </p>

                <p>


                    <label>DNI</label>
                    <input id="DNI_Coordinador" class="form-control" name="DNI_Coordinador" type="text" align="left"/>
                </p>




                <p>


                    <label>Departamento</label>
                    <input id="Departamento" class="form-control" name="Departamento" type="text" align="left"/>
                </p>






            </div>
            <div id="butAltaProfesor">
                <button  id="Alta" name="Alta" type="submit">Alta</button>
            </div>

            <div id="volver">
                <a href="PropuestaLA?accion=volverProfesor">Volver</a>

            </div>



        </form>

        <%
            String mensaje = (String) request.getAttribute("confirmacion");
            if (mensaje == "error") {%>
        <script>
            alert('No se ha podido dar de alta el alumno');
        </script><%}%>
        <%if (mensaje == "correcto") {%>
        <script>
            alert('Coordinador dado de alta correctamente');
        </script><%}%>
    </body>
</html>

