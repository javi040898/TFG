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
        <link rel="stylesheet" href="C:\Users\Javier\Documents\GitHub\TFG\TFG\src\java\css\style.css" type="text/css">        <title>NUEVA ESTANCIA</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            body{
                background:#F5F5F5;
                
            }
        </style>
    </head>
    <body>


        <form action="ProfesorController?accion=insertarEstanciaYAlumno" method="POST" autocomplete="off">
            <div id="form10">
                <h1>NUEVA ESTANCIA</h1>

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
                </p>



                <p>


                    <label>Tipo de estancia</label>
                    <select class="form-control" name="Tipo" id="Tipo">
                        
                        <option>Escoge un tipo de estancia</option>
                        
                        <option>Erasmus1</option>

                        <option>Erasmus2</option>

                        <option>Erasmus3</option>

                    </select>
                </p>
                <p>


                    <label>Curso Academico</label>
                    <select class="form-control" name="Curso" id="Curso">
                        
                        <option>Escoge un curso academico</option>
                        
                        <option>21-22</option>

                        <option>22-23</option>

                        <option>23-24</option>

                    </select>
                </p>
                <p>


                    <label>Duracion</label>
                    <select class="form-control" name="Duracion" id="Duracion">
                        
                        <option>Escoge una duracion</option>
                        
                        <option>1º cuatrimestre</option>

                        <option>2º cuatrimestre</option>

                        <option>Curso completo</option>

                    </select>

                </p>

                <p>


                    <label>Universidad</label>
                    <select class="form-control" id="Universidad" name="Universidad">


                    <option>Escoge una universidad</option>
                    <%

                        List<Universidad_Destino> listaUniversidades= (List<Universidad_Destino>) request.getAttribute("listaUniversidades");
                        if (listaGrados != null)
                            for (Universidad_Destino universidad : listaUniversidades) {%>
                    <option value="<%=universidad.getCodigo_erasmus()%>"><%=universidad.getNombre()%><%=" (" + universidad.getCodigo_erasmus()+ " )"%></option>
                    <% }%>





                </select>
                </p>

            </div>
            <div id="butAlta">
                <button  id="Alta" name="Alta" type="submit">Alta</button>
            </div>



        </form>
    </body>
</html>
