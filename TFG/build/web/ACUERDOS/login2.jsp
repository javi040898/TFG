<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <div class="container mt-5">
        <div class="row">
            <div class="col-sm">
                <form>
                    <form method="post" action="login.jsp" >
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" class="form-control" name="usuario" placeholder="">
                            
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password" placeholder="">
                            
                        </div>
                        <button type="submit" class="btn btn-primary" name="login" >Login</button>
                    </form>
                    <%
                        Connection con = null;
                        Statement st = null;
                        ResultSet rs = null;
                        if (request.getParameter("login") != null) {
                            String user = request.getParameter("usuario");
                            String password = request.getParameter("password");
                            HttpSession sesion = request.getSession();
                            try {
                                Class.forName("org.postgresql.Driver").newInstance();
                                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TFG", "postgres", "postgres");
                                st = con.createStatement();
                                rs = st.executeQuery(" select * from Profesor where usuario='" + user + "' and passw='" + password + "'; ");
                                while (rs.next()) {
                                    
                                    sesion.setAttribute("usuario", rs.getString("usuario"));
                                    sesion.setAttribute("password", rs.getString("passw"));
                                    response.sendRedirect("index.jsp");
                                }
                                out.print(" <div class=\"alert alert-danger\" role=\"alert\"> Usuario no valido </div>");
                            } catch (Exception e) {
                            }
                        }
                    %>

            </div>
        </div>
    </div>
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