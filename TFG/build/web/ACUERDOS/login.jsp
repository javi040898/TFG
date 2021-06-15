<%-- 
    Document   : index
    Created on : 16-ene-2021, 20:00:01
    Author     : Javier
--%>

<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <title>INICIAR SESION</title>
    </head>
    <body>

        <style>
            #cuadroUsuario{
                float:left;

                margin:25px;
                padding:10px;
                position:absolute;
                top:20px;
                right:400px;
                width:500px;

            }

            #cuadroPassword{
                float:left;

                margin:25px;
                padding:10px;
                position:absolute;
                top:120px;
                right:400px;
                width: 500px;

            }

            #butLogin{

                position:absolute;

                display:block;



                left:420px;
                top:250px;

            }
            body {
                background:#F5F5F5;
                font-family: sans-serif; 
            }

        </style>

        <h1 align = "center"><font face="Courier" size=6>
            PROPUESTA LEARNING AGREEMENT ESTUDIANTES UNIVERSIDAD DE ALCALA</font></h1>
        <p align="center">



        <div class="container mt-5">
            <div class="row">
                <div class="col-sm">

                    <form method="POST" action="PropuestaLA?accion=comprobarLogin" autocomplete="off" >
                        <div class="form-group" id="cuadroUsuario">
                            <label>Usuario</label>
                            <input type="text" class="form-control" name="usuario" id="usuario" placeholder="" size="20">

                        </div>
                        <div class="form-group" id="cuadroPassword">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="">

                        </div>


                        <div id="butLogin">
                            <button type="submit" class="btn btn-primary" name="login" >Login</button>
                        </div>
                        <%
                            String mensaje = (String) request.getAttribute("error");
                            if (mensaje == "error") {%>
                        <script>
                            alert('Credenciales introducidas incorrectas');
                        </script><%}%>

                    </form>


                </div>
            </div>
        </div>

    </body>
</html>