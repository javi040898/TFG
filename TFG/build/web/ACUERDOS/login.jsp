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
        <img src="..\img\uah.png" id="imagenuah"/>  
        <img src="..\img\european.png" width="166" height="83" id="imagenue" align="right" hspace=500/>


        <style>
            body{
                background:#3C82B6;
            }
        </style>

        <h1 align = "center"><font face="Courier" size=7>
            INICIAR SESION</font></h1>
        <p align="center"> 

        <div class="container mt-5">
            <div class="row">
                <div class="col-sm">

                    <form method="POST" action="ProfesorController?accion=comprobarLogin" autocomplete="off" >
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" class="form-control" name="usuario" id="usuario" placeholder="">

                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="">

                        </div>
                        


                        <button type="submit" class="btn btn-primary" name="login" >Login</button>
                    </form>
                    <%
                        /* Connection con = null;
                        Connection con2 = null;
                        Statement st = null;
                        Statement st2 = null;
                        ResultSet rs = null;
                        ResultSet rs2 = null;
                        if (request.getParameter("login") != null) {
                            String user = request.getParameter("usuario");
                            String password = request.getParameter("password");
                            HttpSession sesion = request.getSession();
                            HttpSession sesion2 = request.getSession();
                            try {
                                Class.forName("org.postgresql.Driver").newInstance();
                                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TFG", "postgres", "postgres");
                                st = con.createStatement();
                                //rs = st.executeQuery(" select * from Profesor where usuario='" + user + "' and passw='" + password + "'; ");
                                rs = st.executeQuery(" select * from Profesor where usuario='" + user + "' and passw='" + password + "'; ");
                                
                                while(rs.next()){
                                    sesion.setAttribute("usuario", rs.getString("usuario"));
                                    sesion.setAttribute("password", rs.getString("passw"));
                                    response.sendRedirect("profesor.jsp");
                                }
                                rs2 = st.executeQuery(" select * from Alumno where usuario='" + user + "' and passw='" + password + "'; ");
                                while(rs2.next()){
                                    sesion.setAttribute("usuario2", rs2.getString("usuario"));
                                    sesion.setAttribute("password2", rs2.getString("passw"));
                                    response.sendRedirect("alumno.jsp");
                                }
                                
                                   out.print(" <div class=\"alert alert-danger\" role=\"alert\"> Usuario no valido </div>"); */

 /*while (rs.next()) {
                                    
                                    sesion.setAttribute("usuario", rs.getString("usuario"));
                                    sesion.setAttribute("password", rs.getString("passw"));
                                    response.sendRedirect("profesor.jsp");
                                }*/
                        //out.print(" <div class=\"alert alert-danger\" role=\"alert\"> Usuario no valido </div>");
                        /*  } catch (Exception e) {
                            }
                        }*/
                    %>

                </div>
            </div>
        </div>
        <a href="" > Nuevo</a>


    </body>
    <%/*
        if (request.getParameter("login") != null) {
            String user = request.getParameter("usuario");
            String password = request.getParameter("passw");
            HttpSession sesion = request.getSession();
            if (user.equals("admin") && password.equals("admin")) {
                sesion.setAttribute("logueado", "1");
                sesion.setAttribute("user", user);
                response.sendRedirect("index.jsp");
            } else {
                out.print("usuario o contraseña invalidos");
            }
        }*/
    %>
</html>