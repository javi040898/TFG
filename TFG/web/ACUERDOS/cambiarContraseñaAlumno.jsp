<%-- 
    Document   : cambiarContraseña
    Created on : 03-abr-2021, 18:49:11
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     <title>CAMBIO CONTRASEÑA</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
            

            #form9 {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                left:600px;


            }


            #butCambiar{

                float:left;

                margin:25px;
                padding:10px;
                position:absolute;
                top:136px;
                left:378px;


            }

            


            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }



           
        </style>
        <title>CAMBIAR CONTRASEÑA</title>

    </head>
    <body>



        <form action="PropuestaLA?accion=cambiarPasswAlumno" method="POST" autocomplete="off">

            <div id="form9">
                <h1>CAMBIAR CONTRASEÑA</h1>
                <label>Contraseña antigua</label>
                <input id="PasswA" class="form-control" name="PasswA" type="password" align="left"/>
                <label>Contraseña nueva</label>
                <input type="password" class="form-control" name="PasswN1" id="PasswN1" placeholder="">
                <label>Repetir contraseña nueva</label>
                <input type="password" class="form-control" name="PasswN2" id="PasswN2" placeholder="">

            </div>
            <div id="butCambiar">


                <button  id="butCambiar" class="btn btn-primary" name="butCambiar" type="submit" >Cambiar</button>
            </div>
            <%
                String mensaje = (String) request.getAttribute("confirmacion");
                if (mensaje == "error") {%>
            <script>
                alert('Cambio de contraseña incorrecto');
            </script><%}%>
            <%if (mensaje == "correcto") {%>
            <script>
                alert('Cambio de contraseña correcto');
            </script><%}%>



        </form>
        <div id="volver">
            <a href="PropuestaLA?accion=volverAlumno">Volver</a>

        </div>
    </body>
</html>
