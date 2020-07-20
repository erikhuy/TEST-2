/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dtos.BookDTO;
import sample.dtos.CartDTO;
/**
 *
 * @author Huy
 */
@WebServlet(name = "BorrowController", urlPatterns = {"/BorrowController"})
public class BorrowController extends HttpServlet {

    public static final String ERROR = "invalid.html";
    public static final String SUCCESS = "searchBook.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        String bookID = request.getParameter("txtBookID");
        String bookName = request.getParameter("txtBookName");
        String author = request.getParameter("txtAuthor");
        String price = (String) request.getParameter("txtPrice");
        String quantity = (String) request.getParameter("txtQuantity");
        try {
            BookDTO book = new BookDTO(bookID, bookName, author, Integer.parseInt(price), Integer.parseInt(quantity));
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");

            if (cart == null) {
                cart = new CartDTO(null);
            }
            
            cart.add(book);
            session.setAttribute("CART", cart);
            url = SUCCESS;
            request.setAttribute("message", "Ban da them " + bookName + " vao gio hang");

        } catch (Exception e) {
            Logger.getLogger("ERROR at BorrowController"+e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
