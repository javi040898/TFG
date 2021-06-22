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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     <title>INSERTAR ASIGNATURAS ORIGEN</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
            }
            #form1,#form2{

                float:left;
                left:530px;
                margin:50px;
                padding:60px;

                position:relative;
                top:-10px;


            }


            #butInsertarAsignaturasOrigen{

                position:absolute;

                display:block;



                left:855px;
                top:540px;

                background:#0CF;

            }






            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }



        </style>
        <title>INSERTAR ASIGNATURAS ORIGEN</title>
    </head>
    <body>

        <form action="PropuestaLA?accion=insertarAsignaturasOrigenAlumno" method="POST" autocomplete="off">


            <div>

                <div id="form1">
                    <h1>NUEVA ASIGNATURA ORIGEN</h1>
                    <label>Codigo Asignatura</label>
                    <input id="CodigoO" class="form-control" name="CodigoO" type="text" align="left"/>
                    <label>Nombre Asignatura</label>
                    <input type="text" class="form-control" name="NombreO" id="NombreO" placeholder="">
                    <label>Creditos</label>
                    <input type="text" class="form-control" name="CreditosO" id="CreditosO" placeholder="">
                    <label>Tipo Asignatura</label>
                    <select class="form-control" id="TipoO" name="TipoO">
                        <option>Escoge un tipo</option>
                        <option>BASICA</option>
                        <option>OBLIGATORIA</option>
                        <option>OPTATIVA</option>
                        <option>TRANSVERSAL</option>
                    </select>

                    <label>Informacion (pagina web)</label>
                    <input type="text" class="form-control" name="InformacionO" id="Informacion" placeholder="">
                </div>


                <br>

                <br><br><br>
            </div>
            <div id="butInsertarAsignaturasOrigen">


                <button  id="insertarAsignaturas" class="btn btn-primary" name="insertarAsignaturas" type="submit" >Insertar</button>
            </div>


        </form>
        <div id="volver">
            <a href="PropuestaLA?accion=volverAlumno">Volver</a>

        </div>

        <%
            String mensaje = (String) request.getAttribute("confirmacion");
            if (mensaje == "error") {%>
        <script>
            alert('No se ha podido dar de alta la asignatura');
        </script><%}%>
        <%if (mensaje == "correcto") {%>
        <script>
            alert('Asignatura insertada correctamente');
        </script><%}%>



    </body>
</html>
