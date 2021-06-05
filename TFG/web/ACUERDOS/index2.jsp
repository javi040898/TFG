<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Saluda humano</title>
        <title>Lista de empleados</title>
    </head>
    <body>
        <%
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
        %>
        <div class="container mt-5">
            <div class="row">
                <div class="col-sm">

                            </tr>
                        <thead>
                            <tr>
                                <th scope="col">usuario</th>
                                <th scope="col">contraseña</th>
                                <th scope="col">nombre</th>
                                <th scope="col">apellidos</th>
                        <br> </br>

                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    Class.forName("org.postgresql.Driver").newInstance();
                                    con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TFG", "postgres", "postgres");
                                    st = con.createStatement();
                                    rs = st.executeQuery("select * from profesor;");
                                    while (rs.next()) {
                            %>

                                <th scope="row"><%= rs.getString(1)%></th>
                                <td><%= rs.getString(2)%></td>
                                <td><%= rs.getString(3)%></td>
                                <td><%= rs.getString(4)%></td>
                            </tr>                                    
                            <%
                                    }
                                } 
                                catch (Exception e) {
                                    out.print("error mysql "+e);
                                }
                            %>
                        </tbody>
                    </table>
                    
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
                        
                        <option>1º cuatrimestre</option>

                        <option>2º cuatrimestre</option>

                        <option>Anual</option>

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
