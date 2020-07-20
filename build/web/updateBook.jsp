<%-- 
    Document   : updateBook
    Created on : Jul 4, 2020, 6:57:30 PM
    Author     : Huy
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page import="sample.dtos.ErrorBookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book</title>
    </head>
    <body>
        <%
            String bookID = request.getParameter("txtBookID");
            String img = request.getParameter("txtImg");
            String bookName = request.getParameter("txtBookName");
            String author = request.getParameter("txtAuthor");
            String price = (String) request.getParameter("txtPrice");
            String quantity = (String) request.getParameter("txtQuantity");
            UserDTO1 user = (UserDTO1) session.getAttribute("USER");
            ErrorBookDTO error = (ErrorBookDTO) request.getAttribute("ERROR_BOOK");
            if (user == null || !user.getRoleID().equalsIgnoreCase("admin")) {


        %>
        <a href="login.html">You Don't Have Authorize</a>
        <%        } else {
            if (error == null) {
                error = new ErrorBookDTO("", "", "", "", "");
            }
        %>
        <a href="searchBook.jsp">Back</a></br>
        <form action="MainController">
            Book ID<input type="text" value="<%= bookID%>"name="txtBookID" readonly="true" style="opacity: 50%"/></br>

            Image Source<input type="text" value="<%= img %>" name="txtBookName"/></br></br>
            
            Book Name<input type="text" value="<%= bookName%>" name="txtBookName"/></br>
            <%= error.getBookNameError()%></br>

            Author<input type="text" value="<%= author%>" name="txtAuthor"/></br>
            <%= error.getAuthorError()%></br>


            Price<input type="number" value="<%= price%>" name="txtPrice" min="1"/></br>

            <%= error.getPriceError()%></br>

            Quantity<input type="number" value="<%= quantity%>" name="txtQuantity" min="1"/></br>
            <%= error.getQuantityError()%></br>

            <input type="submit" value="Update Book" name="btnAction"/>
        </form>
        <%
            }
        %>
    </body>
</html>
