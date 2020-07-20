<%-- 
    Document   : searchBook
    Created on : Jul 1, 2020, 2:44:15 PM
    Author     : Huy
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dtos.BookDTO"%>
<%@page import="sample.dtos.UserDTO1"%>
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
            if (search == null) {
                search = "";
            }
        %>
        <a href="adminOption.jsp">Back</a></br>
        <form action="MainController">
            Search <input type="text" placeholder="Search by Name" name="txtSearch" value="<%= search%>"/>
            <%
                if (user.getRoleID().equals("admin")) {
            %>
            <input type="submit" value="Search Book" name="btnAction"/>
            <%
            } else {
            %>
            <input type="submit" value="|Search Book|" name="btnAction"/>
            <%
                }
            %>
        </form>
        <%
            List<BookDTO> list = (List<BookDTO>) request.getAttribute("LIST_BOOK");
            if (list != null) {
                if (!list.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Book ID</th>
                    <th>Image</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Quantity</th>
                        <%
                            if (user.getRoleID().equals("admin")) {
                        %>
                    <th>Delete</th>
                    <th>Update</th>
                        <%
                        } else {
                        %>
                    <th>Borrow</th>
                        <%
                            }
                        %>
                </tr>
            </thead>
            <tbody>
                <%  int count = 1;
                    for (BookDTO dto : list) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><%=dto.getBookID()%></td>
                    <td> <img src="img/<%= dto.getImg()%>" width="100" height="100" 
                              alt="img/<%=dto.getBookName()%>"/> 
                          
                    </td>
                    <td><%=dto.getBookName()%></td>
                    <td><%=dto.getAuthor()%></td>
                    <td><%=dto.getPrice()%></td>
                    <td><%=dto.getQuantity()%></td>
                    <%
                        if (user.getRoleID().equals("admin")) {
                    %>
                    <td>
                        <a href="MainController?btnAction=Delete Book&txtBookID=<%= dto.getBookID()%>&txtSearch=<%= search%>">Delete</a>
                    </td>
                    <td>
                        <form action="MainController">
                            <input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>"/>
                            <input type="hidden" name="txtImg" value="<%= dto.getImg()%>"/>
                            <input type="hidden" name="txtBookName" value="<%= dto.getBookName()%>"/>
                            <input type="hidden" name="txtAuthor" value="<%= dto.getAuthor()%>"/>
                            <input type="hidden" name="txtPrice" value="<%= dto.getPrice()%>"/>
                            <input type="hidden" name="txtQuantity" value="<%= dto.getQuantity()%>"/>

                            <input type="submit" name="btnAction" value="Update_Book"/>
                        </form>
                    </td>
                </tr>
                <%
                } else {
                %>
            <td>
                <form action="MainController">
                    <input type="hidden" name="txtBookID" value="<%= dto.getBookID()%>"/>
                    <input type="hidden" name="txtBookName" value="<%= dto.getBookName()%>"/>
                    <input type="hidden" name="txtAuthor" value="<%= dto.getAuthor()%>"/>
                    <input type="hidden" name="txtPrice" value="<%= dto.getPrice()%>"/>
                    <input type="hidden" name="txtQuantity" value="<%= dto.getQuantity()%>"/>

                    <input type="submit" name="btnAction" value="Borrow"/>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>
<%
            }

        }
    }
    String message = (String) request.getAttribute("message");
    if (message == null) {
        message = "";
    }
%>
<h3><%= message%></h3>
<%
    if (user.getRoleID().equals("user")) {
%>
<a href="viewCart.jsp">View Cart</a>
<%
    }
%>


</body>
</html>
