<%-- 
    Document   : prueba
    Created on : 16-mar-2021, 11:33:03
    Author     : Javier
--%>
*/<option value="<%=asignaturaD.getCodigo()%>"><%=asignaturaD.getNombre()%><%=" (" + asignaturaD.getCodigo() + ")"%></option>
 <select class="form-control" id="listaAsignaturasModificar" name="listaAsignaturasModificar">
                    <option>Escoge una asignatura</option>
                    <% if (listaAsignaturasDestino != null)
                            for (Asignatura_Destino asignaturaD : listaAsignaturasDestino) {
                                if (asignaturaD.getEstado().equals("Pendiente")) {
                    %>
                    <option value="<%=asignaturaD.getCodigo()%>"><%=asignaturaD.getNombre()%><%=" (" + asignaturaD.getCodigo() + ")"%></option>
                    <% }
                        }%>
#butAceptar{
                float:left;

                margin:25px;
                padding:10px;
                position:relative;

                display:block;



                left:568px;
                top:32px;



            }

            #volver{
                float:left;
                position:absolute;
                top:20px;
                left:20px;
            }

            #modificarEstado {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:110px;
                right:570px;

            }

            #enlaceNuevo{

                position:absolute;

                display:block;



                left:350px;
                top:20px;



            }

            #comentariosModificada {
                float:left;

                margin:15px;
                padding:10px;
                position:relative;
                top:300px;
                left: -930px;

            }

            #comentariosCancelada {
                float:left;

                margin:15px;
                padding:10px;
                position:relative;
                top:30px;
                left: -25px;

            }

            #listaAsignaturaCancelar {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:95px;
                right:60px;

            }

            #butModificar{

                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:90px;
                right:-80px;

            }

            #labelCancelar {
                float:left;

                margin:15px;
                padding:10px;
                position:relative;
                top:152px;
                left: -310px;

            }

            #tituloCancelar{

                float:left;
                left:500px;
                margin:60px;
                padding:10px;
                top:5px;
                position:relative;



            }

            #butCancelar{

                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:-130px;
                right:-1540px;

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

            #tituloModificar{

                float:left;
                left:10px;
                margin:60px;
                padding:10px;
                top:150px;
                position:relative;



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

            #listaEstanciasAlumnos {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:2px;
                left: 280px;

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

            #titulo1{

                float:left;
                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:310px;
                position:absolute;
                left:20px;


            }

            #titulo2{

                float:left;
                left:1000px;

                background:#E3D5CD;
                margin:20px;
                padding:10px;
                top:310px;
                position:absolute;



            }

            #tablaProfesor table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -200px;

            }
            #tablaProfesor th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                background:#EDE6E2;
                padding: 0.3em;
            }

            #tablaCreditosOrigen table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -195px;

            }
            #tablaCreditosOrigen th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }



            #tablaCreditosDestino table {
                width: 100%;
                border: black 1px solid;
                position: relative;
                bottom: -195px;

            }
            #tablaCreditosDestino th, td {

                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                border: hidden;
                padding: 0.3em;
            }

            #listaAsignaturasModificar {
                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:110px;
                right:300px;


            }




                </select>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <p class="inline">
        <div class="form-group mx-sm-3">
       <label for="inputUser" class="sr-only">User</label>
       <input type="password" class="form-control" id="inputUser" placeholder="User">
   </div>
   <div class="form-group mx-sm-3">
       <label for="inputPass" class="sr-only">Password</label>
       <input type="password" class="form-control" id="inputPass" placeholder="Pass">
   </div>
    </p>    

<div><h1>ASIGNATURA ORIGEN &nbsp  &nbsp &nbsp &nbsp &nbsp
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        ASIGNATURA DESTINO 1 &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                ASIGNATURA DESTINO 2</h1></div>
</html>
<img src="C:\Users\Javier\Documents\GitHub\TFG\TFG\web\img\flecha.png"