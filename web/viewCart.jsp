<%-- 
    Document   : viewCart
    Created on : Jul 15, 2020, 1:04:54 AM
    Author     : Huy
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dtos.UserDTO"%>
<%@page import="sample.dtos.UserDTO1"%>
<%@page import="sample.dtos.BookDTO"%>
<%-- 
    Document   : view
    Created on : Jun 11, 2020, 3:25:24 PM
    Author     : Huy
--%>

<%@page import="sample.dtos.UserDTO1"%>
<%@page import="sample.dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <%
            String bookName = request.getParameter("txtBookName");
            UserDTO1 user = (UserDTO1) session.getAttribute("USER");
            if (user == null) {
        %>
        <a href="login.html">You Don't Have Authorize</a>
        <%        } else {
        %>
        <h1>Your Cart:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>BOOK ID</th>
                    <th>BOOK NAME</th>
                    <th>AUTHOR</th>
                    <th>PRICE</th>
                    <th>BORROW DATE</th>
                    <th>REMOVE</th>
                    <th>CHECK OUT</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    int total = 0;
                    for (BookDTO dto : cart.getCart().values()) {
                        total += dto.getPrice() * 1;
                %>
            <form action="MainController">
                <tr>
                    <td><%= count++%></td>
                    <td><%= dto.getBookID()%>
                    <input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>"/>
                    </td>
                    
                    <td><%= dto.getBookName()%></td>
                    <td><%= dto.getAuthor()%></td>
                    <td><%= dto.getPrice()%></td>
                    <td><input type="date" name="txtBorrowDate" value="2020-07-15" min="2020-07-15" >   </td>
                    <td><input type="submit" name="btnAction" value="Remove"/></td>
                <input type="hidden" name="txtBookName" value="<%= bookName%>"/>
                <input type="hidden" name="txtUserID" value="<%= user.getUserName()%>"/>
                <td><input type="submit" name="btnAction" value="Check Out"/></td>
                </tr>
            </form> 
            <%
                }
            %>
        </tbody>
    </table>
    <h1>Total: <%= total%> </h1>
    <%
        }
        String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "";
        }
    %>
    <h3><%= message%></h3>
    <a href="searchBook.jsp">Continue to borrow</a></br>
    <%
        }
    %>

</body>
</html>

