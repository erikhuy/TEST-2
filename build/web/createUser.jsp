<%-- 
    Document   : create
    Created on : Jun 4, 2020, 4:21:35 PM
    Author     : Huy
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page import="sample.dtos.ErrorUserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>
    </head>
    <body>
        <%
            UserDTO1 user = (UserDTO1) session.getAttribute("USER");
        %>
        <%
            if (user == null || !user.getRoleID().equalsIgnoreCase("admin")) {
        %>
        <a href="login.html">You Don't Have Authorize</a>
        <%
        } else {
        %>
        <%
            ErrorUserDTO error = (ErrorUserDTO) request.getAttribute("ERROR");
            if (error == null) {
                error = new ErrorUserDTO("", "", "", "", "");
            }
        %>
        <a href="adminOption.jsp">Back</a></br>
        <form action="MainController" method="POST">
            UserID<input type="text" name="txtUserID"/></br>

            <%= error.getUserIDError()%></br>
            UserName<input type="text" name="txtUserName"/></br>

            <%= error.getUserNameError()%></br>
            Role ID <select name="txtRoleID">
                <option value="admin">admin</option>
                <option value="user">user</option>
            </select></br>
            Password<input type="text" name="txtPassword"/></br>
            <%= error.getPasswordError()%></br>
            
            RePassword<input type="text" name="txtRePassword"/></br>
            <%= error.getRePasswordError()%></br>

            <input type="submit" name="btnAction" value="Create User"/></br>


        </form>
        <%
            }
        %>
    </body>
</html>
