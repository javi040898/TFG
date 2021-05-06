<%-- 
    Document   : convalidacionç
    Created on : 06-mar-2021, 13:56:33
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>CONVALIDACION</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
        </style>
        <title>CONVALIDACION</title>
    </head>
    <body>
        <div class="div02"> CONVALIDACIONES</div>


        <form action="ProfesorController?accion=insertarConvalidacion" method="POST" autocomplete="off">


            <div>

                <div id="form1">
                    <h1>ASIGNATURA ORIGEN</h1>
                    <label>Codigo</label>
                    <input id="CodigoO" class="form-control" name="CodigoO" type="text" align="left"/>
                    <label>Nombre</label>
                    <input type="text" class="form-control" name="NombreO" id="NombreO" placeholder="">
                    <label>Creditos</label>
                    <input type="text" class="form-control" name="CreditosO" id="CreditosO" placeholder="">
                    <label>Tipo</label>
                    <input type="text" class="form-control" name="TipoO" id="TipoO" placeholder="">
                    <label>Informacion</label>
                    <input type="text" class="form-control" name="InformacionO" id="Informacion" placeholder="">
                </div>











                <div id="form2">
                    <h1>ASIGNATURA DESTINO 1</h1>
                    <label>Codigo</label>
                    <input id="CodigoD1" class="form-control" name="CodigoD1" type="text" align="left"/>
                    <label>Nombre</label>
                    <input type="text" class="form-control" name="NombreD1" id="NombreD1" placeholder="">
                    <label>Creditos</label>
                    <input type="text" class="form-control" name="CreditosD1" id="CreditosD1" placeholder="">
                    <label>Informacion</label>
                    <input type="text" class="form-control" name="InformacionD1" id="InformacionD1" placeholder="">

                </div>






                <div id="form3">
                    <h1>ASIGNATURA DESTINO 2</h1>
                    <label>Codigo</label>
                    <input id="CodigoD2" class="form-control" name="CodigoD2" type="text" align="left"/>
                    <label>Nombre</label>
                    <input type="text" class="form-control" name="NombreD2" id="NombreD2" placeholder="">
                    <label>Creditos</label>
                    <input type="text" class="form-control" name="CreditosD2" id="CreditosD2" placeholder="">
                    <label>Informacion</label>
                    <input type="text" class="form-control" name="InformacionD2" id="InformacionD2" placeholder="">

                </div>

                <br>

                <br><br><br>
            </div>
            <div id="butConvalidacion">


                <button  id="Convalidacion" class="btn btn-primary" name="Convalidacion" type="submit" >Alta</button>
            </div>


        </form>



    </body>
</html>
