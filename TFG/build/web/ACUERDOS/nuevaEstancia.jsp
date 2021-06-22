<%-- 
    Document   : nuevaEstancia
    Created on : 28-feb-2021, 17:32:32
    Author     : Javier
--%>

<%@page import="modelo.Alumno"%>
<%@page import="modelo.Alumno"%>
<%@page import="modelo.Universidad_Destino"%>
<%@page import="modelo.Grado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     <title>NUEVA ESTANCIA</title>
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

 

            #butAltaEstancia{

                float:left;

                margin:25px;
                padding:10px;
                position:relative;
                top:450px;
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


        <form action="PropuestaLA?accion=insertarEstancia" method="POST" autocomplete="off">
            <div id="form10">
                <h1>NUEVA ESTANCIA</h1>

                <select class="form-control" id="listaAlumnosEstancia" name="listaAlumnosEstancia">



                    <option>Escoge un alumno</option>
                    <%

                        List<Alumno> listaAlumnos = (List<Alumno>) request.getAttribute("listaAlumnosEstancia");
                        if (listaAlumnos != null)
                            for (Alumno alumno : listaAlumnos) {%>
                    <option value="<%=alumno.getDNI()%>"><%=alumno.getNombre()%><%=" " + alumno.getApellidos()%><%=" (" + alumno.getDNI() + " )"%></option>
                    <% }%>





                </select>

                <label>Tipo de estancia</label>
                <select class="form-control" name="Tipo" id="Tipo">

                    <option>Escoge un tipo de estancia</option>

                    <option>KA103</option>

                    <option>KA107</option>


                </select>
                </p>
                <p>


                    <label>Curso Academico</label>
                    <input id="Curso" class="form-control" name="Curso" type="text" align="left"/>
                </p>
                <p>


                    <label>Duracion</label>
                    <select class="form-control" name="Duracion" id="Duracion">

                        <option>Escoge una duracion</option>

                        <option>Cuatrimestre 1</option>

                        <option>Cuatrimestre 2</option>

                        <option>Anual</option>

                    </select>

                </p>

                <p>


                    <label>Universidad</label>
                    <select class="form-control" id="Universidad" name="Universidad">


                        <option>Escoge una universidad</option>
                        <%

                            List<Universidad_Destino> listaUniversidades = (List<Universidad_Destino>) request.getAttribute("listaUniversidades");
                            if (listaUniversidades != null)
                                for (Universidad_Destino universidad : listaUniversidades) {%>
                        <option value="<%=universidad.getCodigo_erasmus()%>"><%=universidad.getNombre()%><%=" (" + universidad.getCodigo_erasmus() + " )"%></option>
                        <% }%>





                    </select>
                </p>





            </div>
            <div id="butAltaEstancia">
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
            alert('No se ha podido dar de alta la estancia');
        </script><%}%>
        <%if (mensaje == "correcto") {%>
        <script>
            alert('Estancia dada de alta correctamente');
        </script><%}%>
    </body>
</html>
