/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.daos.BookDAO;
import sample.dtos.BookDTO;
import sample.dtos.ErrorBookDTO;

/**
 *
 * @author Huy
 */
@WebServlet(name = "UpdateBookController", urlPatterns = {"/UpdateBookController"})
public class UpdateBookController extends HttpServlet {

    public static final String ERROR = "updateBook.jsp";
    public static final String SUCCESS = "SearchBookController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ErrorBookDTO errorBook = new ErrorBookDTO();

        try {
            
            String bookID = request.getParameter("txtBookID");
            String bookName = request.getParameter("txtBookName");
            String author = request.getParameter("txtAuthor");
            String price = (String) request.getParameter("txtPrice");
            String quantity = (String) request.getParameter("txtQuantity");
            
            boolean check = true;
            if (bookName == null || bookName.length() < 2) {
                errorBook.setBookNameError("Book Name is not null and lenght > 2");
                check = false;
            } else {
                errorBook.setBookNameError("✔");
            }

            if (author == null || author.length() < 3) {
                errorBook.setAuthorError("Author is not null and lenght > 3");
                check = false;
            } else {
                errorBook.setAuthorError("✔");
            }

            if (price == null||price.length() < 4) {
                errorBook.setPriceError(" Price > 1000");
                check = false;
            } else {
                errorBook.setPriceError("✔");
            }

            if (quantity == null||quantity.length() < 1) {
                errorBook.setQuantityError(" Quantity > 0");
                check = false;
            } else {
                errorBook.setQuantityError("✔");
            }

            if (check) {
                BookDTO dto = new BookDTO(bookID,bookName, author, Integer.parseInt(price), Integer.parseInt(quantity));
                BookDAO dao = new BookDAO();
                dao.update(dto);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_BOOK", errorBook);
            }

        } catch (Exception e) {
            request.setAttribute("ERROR_BOOK", errorBook);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
