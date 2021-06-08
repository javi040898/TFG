<%-- 
    Document   : nuevaEstancia
    Created on : 28-feb-2021, 17:32:32
    Author     : Javier
--%>

<%@page import="modelo.Universidad_Destino"%>
<%@page import="modelo.Grado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>NUEVA ALUMNO</title>
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
                <h1>NUEVO ALUMNO</h1>

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
                    <input id="DNI_Alumno" class="form-control" name="DNI_Alumno" type="text" align="left"/>
                </p>


                <label>Grado</label>
                <select class="form-control" id="Grado" name="Grado">


                    <option>Escoge un grado</option>
                    <%

                        List<Grado> listaGrados = (List<Grado>) request.getAttribute("listaGrados");
                        if (listaGrados != null)
                            for (Grado grado : listaGrados) {%>
                    <option value="<%=grado.getCodigo()%>"><%=grado.getNombre()%><%=" (" + grado.getCodigo() + " )"%></option>
                    <% }%>





                </select>






            </div>
            <div id="butAltaAlumno">
                <button  id="Alta" name="Alta" type="submit">Alta</button>
            </div>

            <div id="volver9">
                <a href="ProfesorController?accion=volverProfesor">Volver</a>

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
            alert('Alumno dado de alta correctamente');
        </script><%}%>
    </body>
</html>
