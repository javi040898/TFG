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
            #form1,#form2{

                float:left;
                left:530px;
                margin:50px;
                padding:60px;

                position:relative;
                top:-10px;


            }

            #titulo1{

                float:left;
                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:260px;
                position:absolute;
                left:20px;


            }

            #titulo2{

                float:left;
                left:1000px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:260px;
                position:absolute;



            }
            #tituloModificar{

                float:left;
                left:30px;
                margin:60px;
                top:150px;
                position:relative;
                font-size: xx-large;



            }

            #tituloCancelar{

                float:left;
                left:0px;
                margin:60px;
                top:60px;
                position:relative;
                font-size: xx-large;


            }



            #titulo3{

                float:left;
                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:200px;
                position:absolute;
                left:20px;


            }

            #titulo4{

                float:left;
                left:1000px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:200px;
                position:absolute;



            }


            #titulo5{

                float:left;
                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:175px;
                position:absolute;
                left:20px;


            }

            #titulo6{

                float:left;
                left:1000px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:175px;
                position:absolute;



            }

            #NombreAlumno{

                float:left;
                left:1570px;

                margin:20px;
                padding:10px;
                top:0px;
                position:absolute;
                color: #050404



            }

            #ApellidosAlumno{

                float:left;
                left:1570px;

                margin:20px;
                padding:10px;
                top:20px;
                position:absolute;
                color: #050404



            }
            #CodigoGrado{

                float:left;
                left:1570px;

                margin:20px;
                padding:10px;
                top:40px;
                position:absolute;
                color: #050404



            }
            #NombreGrado{

                float:left;
                left:1570px;

                margin:20px;
                padding:10px;
                top:60px;
                position:absolute;
                color: #050404;



            }
            #Facultad{

                float:left;
                left:1570px;

                margin:20px;
                padding:10px;
                top:80px;
                position:absolute;
                color: #050404;




            }




            #form4 {
                background-color: white;
                float:left;
                border: black 1px solid;
                display:block;
                position:absolute;
                bottom: 10px;
            }

            #form5 {
                float:left;

                margin:50px;
                padding:10px;
                position:relative;
                top:30px;
                left: 600px;
            }

            #comentariosModificada {
                float:left;

                margin:15px;
                position:relative;
                top:0px;
                left: -15px;

            }

            #comentariosCancelada {
                float:left;

                margin:15px;
                position:relative;
                top:30px;
                left: 400px;

            }
            #label1 {
                float:left;

                margin:15px;
                position:relative;
                top:39px;
                left: 934px;

            }


            #form6 {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:2px;
                left: 600px;

            }
            #form7 {
                float:left;

                margin:25px;
                position:relative;
                top:250px;
                right:580px;

            }

            #form11 {
                float:left;

                margin:25px;
                position:relative;
                top:-15px;
                right:-1266px;

            }

            #form12{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:200px;
                right:-600px;

            }

            #form13{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:300px;
                right:100x;

            }


            #form14{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:300px;
                right:-50px;

            }

            #form15{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:100px;
                right:-700px;

            }
            #form16{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:100px;
                right:-700px;

            }

            #form17{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:50px;
                right:-600px;

            }

            #form18{
                float:left;

                margin:25px;
                padding:10px;
                position:absolute;
                top:20px;
                right:400px;
                width:500px;

            }

            #form19{
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

            #butAceptarConvalidacion{

                position:absolute;

                display:block;



                left:825px;
                top:400px;

            }
            #butInsertarUniversidad{

                position:absolute;

                display:block;



                left:780px;
                top:390px;

            }
            #butInsertarGrado{

                position:absolute;

                display:block;



                left:730px;
                top:320px;

            }

            #butAceptarRenuncia{

                position:absolute;

                display:block;



                left:754px;
                top:160px;

            }

            #butAceptarCierre{

                position:absolute;

                display:block;



                left:754px;
                top:160px;

            }

            #butConfirmarEstancia{

                position:absolute;

                display:block;



                left:515px;
                top:42px;

            }

            #form8 {
                float:left;

                margin:25px;
                position:relative;
                top:250px;
                right:560px;

            }

            #form9 {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                left:600px;


            }

            #form20{

                float:left;

                margin:25px;
                position:absolute;
                top:1500px;
                right:560px;


            }

            #form10 {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                left:600px;


            }

            #butInsertarAsignaturasDestino{

                position:absolute;

                display:block;



                left:875px;
                top:540px;

                background:#0CF;

            }

            #butInsertarAsignaturasOrigen{

                position:absolute;

                display:block;



                left:855px;
                top:540px;

                background:#0CF;

            }




            #butBuscador{

                position:absolute;

                display:block;



                left:825px;
                top:175px;

                background:#0CF;

            }

            #butAceptar{
                float:left;

                margin:25px;
                padding:10px;
                position:absolute;

                display:block;



                left:1380px;
                top:20px;



            }

            #butModificar{

                float:left;

                margin:25px;
                position:relative;
                top:252px;
                right:565px;

            }
            #butCancelar{

                float:left;

                margin:25px;
                position:relative;
                top:-12px;
                right:-650px;

            }

            #butCambiar{

                float:left;

                margin:25px;
                padding:10px;
                position:absolute;
                top:136px;
                left:378px;


            }

            #butAltaAlumno{

                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:580px;
                left:350px;

            }

            #butAltaProfesor{

                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:580px;
                left:350px;

            }

            #butAltaEstancia{

                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:450px;
                left:350px;

            }

            #enlaceNuevo{

                position:absolute;

                display:block;



                left:350px;
                top:20px;



            }

            #enlacesAlumno{

                position:absolute;

                display:block;



                left:700px;
                top:110px;



            }


            #table1 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -200px;

            }
            #table1 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                background:#EDE6E2;
                padding: 0.3em;
            }

            #table2 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -70px;


            }
            #table2 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                background:#EDE6E2;
                padding: 0.3em;
            }

            #table3 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -195px;

            }
            #table3 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }



            #table5 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -195px;

            }
            #table5 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }

            #table6 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -150px;

            }
            #table6 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }



            #table7 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -150px;

            }
            #table7 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }

            #table4 table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -130px;

            }
            #table4 th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                background:#EDE6E2;
                padding: 0.3em;
            }


            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }



            body {
                background:#F5F5F5;
                font-family: sans-serif; 
            }

            hr { 
                border: 1px solid #DDDDDD; 
                margin: 100px 50px; 

            }
            #header h1 { 
                display:inline; 

            }


            #header h12 { 
                text-indent:1000px;

            }

            .div01{
                color: black;
                font-size:30px;
            }

            .div02{
                position:absolute;

                display:block;

                font-size:70px;

                left:500px;

            }
            .div03{
                position:absolute;

                display:block;

                font-size:70px;

                left:500px;

            }
            .div06{
                position:absolute;

                display:block;

                font-size:35px;

                left:500px;

            }

            .div07{
                position:absolute;

                display:block;

                font-size:35px;

                left:700px;

            }
            .div08{
                position:absolute;

                display:block;

                font-size:35px;

                left:670px;
                top:130px;

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
            System.out.println("mensaje: " + mensaje);
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

