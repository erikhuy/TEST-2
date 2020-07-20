<%-- 
    Document   : userOption
    Created on : Jun 30, 2020, 6:33:09 PM
    Author     : Huy
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDTO1 user = (UserDTO1) session.getAttribute("USER");
            if (user == null) {
        %>
        <a href="login.html">You Don't Have Authorize</a>
        <%
        } else {
        %>
        <h1>Welcome: <%=user.getUserName()%></h1>
        <a href="MainController?btnAction=Logout">Logout</a></br>
        <hr>
        <a href="searchBook.jsp">Borrow Book</a></br>
        <hr>
        <a href="searchBorrow.jsp">View/Return Book</a></br>
        <hr>
        <a href="borrowedBook.jsp">Return Book</a></br>
    </body>
    <%
        }        %>
</html>
