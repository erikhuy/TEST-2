<%-- 
    Document   : createBook
    Created on : Jul 1, 2020, 10:59:28 PM
    Author     : Huy
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page import="sample.dtos.ErrorBookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Book Page</title>
    </head>
    <body>
        <%
            UserDTO1 user=(UserDTO1)session.getAttribute("USER");
            if(user == null || !user.getRoleID().equalsIgnoreCase("admin")){
        %>
        <a href="login.html">You Don't Have Authorize</a>
        <%
            }else{
        %>
        <%
            ErrorBookDTO error = (ErrorBookDTO) request.getAttribute("ERROR_BOOK");
            if (error == null) {
                error = new ErrorBookDTO("", "", "", "", "");
            }
        %>
        <a href="adminOption.jsp">Back</a></br>
        <form action="MainController" method="POST">
            
            Book ID<input type="text" name="txtBookID"/></br>
            <%= error.getBookIDError()%></br>
            
            Img Source <input type="text" name="txtImg"/></br></br>
            
            Book Name<input type="text" name="txtBookName"/></br>
            <%= error.getBookNameError()%></br>
            
            Book's Author<input type="text" name="txtBookAuthor"/></br>
            <%= error.getAuthorError()%></br>
           
            Price<input type="number" name="txtBookPrice" min="1"/></br>
            <%= error.getPriceError()%></br>
            
            Quantity<input type="number" name="txtQuantity" min="1" /></br>
            <%= error.getQuantityError()%></br>
            
            <input type="submit" name="btnAction" value="Create Book"/></br>
            
        </form>
            <%
                }
                %>
    </body>
</html>
