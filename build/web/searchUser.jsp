<%-- 
    Document   : search
    Created on : Jun 2, 2020, 4:32:03 PM
    Author     : HUY
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page import="sample.dtos.UserDTO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search User Page</title>
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
        <h1>Welcome: <%= user.getUserName()%></h1>
        <%
               String search = request.getParameter("txtSearch");
               if(search == null){
                   search = "";
               }
        %>
        <a href="adminOption.jsp">Back</a></br>
        <form action="MainController">
            Search <input type="text" name="txtSearch" placeholder="Search by Name" value="<%= search %>"/>
            <input type="submit" value="Search User" name="btnAction"/>
        </form>
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null) {
                if (!list.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Delete</th>
                    <th>Update</th>   
                    
                </tr>
            </thead>
            <tbody>
                <%  int count = 1;
                    for (UserDTO dto : list) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><%=dto.getUserID()%></td>
                    <td><%=dto.getUserName()%></td>
                    <td><%=dto.getRoleID()%></td>
                    <td><%=dto.getPassword()%></td>  
                    <td>
                        <form action="MainController">
                            <input type="hidden" name="txtUserID" value="<%= dto.getUserID() %>"/>
                            <input type="submit" name="btnAction" value="Delete User"/>
                        </form>
                       
                    </td>
                    <td>
                        <form action="MainController">
                            <input type="hidden" name="txtUserID" value="<%= dto.getUserID() %>"/>
                            <input type="hidden" name="txtUserName" value="<%= dto.getUserName() %>"/>
                            <input type="hidden" name="txtRoleID" value="<%= dto.getRoleID() %>"/>
                            <input type="hidden" name="txtPassword" value="<%= dto.getPassword()%>"/>
                            <input type="submit" name="btnAction" value="Update_User"/>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>

            </tbody>
        </table>
        <%
                }

            }
}
        %>
    </body>
</html>