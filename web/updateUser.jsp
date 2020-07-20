<%-- 
    Document   : updateUser
    Created on : Jul 4, 2020, 4:47:51 PM
    Author     : Huy
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page import="sample.dtos.ErrorUserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>

        <%
            String userID = request.getParameter("txtUserID");
            String userName = request.getParameter("txtUserName");
            String roleID = request.getParameter("txtRoleID");
            String password = request.getParameter("txtPassword");
            UserDTO1 user = (UserDTO1) session.getAttribute("USER");
            ErrorUserDTO error = (ErrorUserDTO) request.getAttribute("ERROR_USER");

            if (user == null || !user.getRoleID().equalsIgnoreCase("admin")) {

        %>
        <a href="login.html">You Don't Have Authorize</a>
        <%        
        } else {
            if (error == null) {
                error = new ErrorUserDTO("", "", "", "", "");
            }

        %>
        <a href="searchUser.jsp">Back</a></br>
        <form action="MainController">
            User ID<input type="text" value="<%= userID%>"name="txtUserID" readonly="true" style="opacity: 50%"/></br>

            User Name<input type="text" value="<%= userName%>" name="txtUserName"/></br>
            <%= error.getUserNameError()%></br>
            Role ID<input type="text" value="<%= roleID%>" name="txtRoleID" readonly="true" style="opacity: 50%"/></br>

            Password<input type="text" value="<%= password%>" name="txtPassword"/></br>
            <%= error.getPasswordError()%></br>

            <input type="submit" value="Update User" name="btnAction"/>
        </form>
        <%
            }
        %>

    </body>
</html>
