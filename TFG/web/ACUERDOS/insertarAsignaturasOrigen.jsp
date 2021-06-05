<%-- 
    Document   : convalidacionç
    Created on : 06-mar-2021, 13:56:33
    Author     : Javier
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Universidad_Destino"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>INSERTAR ASIGNATURAS ORIGEN</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>INSERTAR ASIGNATURAS ORIGEN</title>
    </head>
    <body>
        <div class="div02">INSERTAR ASIGNATURAS ORIGEN</div>


        <form action="ProfesorController?accion=insertarAsignaturasOrigen" method="POST" autocomplete="off">


            <div>

                <div id="form1">
                    <h1>ASIGNATURA ORIGEN</h1>
                    <label>Codigo Asignatura</label>
                    <input id="CodigoO" class="form-control" name="CodigoO" type="text" align="left"/>
                    <label>Nombre Asignatura</label>
                    <input type="text" class="form-control" name="NombreO" id="NombreO" placeholder="">
                    <label>Creditos</label>
                    <input type="text" class="form-control" name="CreditosO" id="CreditosO" placeholder="">
                    <label>Tipo Asignatura</label>
                    <select class="form-control" id="TipoO" name="TipoO">
                        <option>Escoge un tipo</option>
                        <option>Básica</option>
                        <option>Obligatoria</option>
                        <option>Optativa</option>
                    </select>

                    <label>Informacion</label>
                    <input type="text" class="form-control" name="InformacionO" id="Informacion" placeholder="">
                </div>


                <br>

                <br><br><br>
            </div>
            <div id="butInsertarAsignaturas">


                <button  id="insertarAsignaturas" class="btn btn-primary" name="insertarAsignaturas" type="submit" >Insertar</button>
            </div>


        </form>



    </body>
</html>
