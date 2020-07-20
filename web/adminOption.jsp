<%-- 
    Document   : adminOption
    Created on : Jun 30, 2020, 6:06:33 PM
    Author     : Huy
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Option-</title>
    </head>
    <body>
        <%
            UserDTO1 user = (UserDTO1) session.getAttribute("USER");
            if (user == null) {
        %>
        <a href="login.html">You Don't Have Authorize</a>
        <%
            } else if (user.getRoleID().equalsIgnoreCase("user")) {
                response.sendRedirect("userOption.jsp");
            } else if ( user.getRoleID().equalsIgnoreCase("admin")){
        %>
        <h1>Welcome: <%= user.getUserName()%></h1>
        <a href="MainController?btnAction=Logout">Logout</a></br>
        <hr>
        <a href="createUser.jsp">Create New User</a></br>
        <a href="searchUser.jsp">Search User</a></br>
        <hr>
        <a href="createBook.jsp">Create New Book</a></br>
        <a href="searchBook.jsp">Search Book</a></br>
        <%
            }
        %>
    </body>
</html>
