/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
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
@WebServlet(name = "CreateBookController", urlPatterns = {"/CreateBookController"})
public class CreateBookController extends HttpServlet {

    public static final String CREATE = "createBook.jsp";
    public static final String OPTION = "adminOption.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ErrorBookDTO errorBook = new ErrorBookDTO();
        String url = CREATE;
        boolean check = true;
        
        String bookID = request.getParameter("txtBookID");
        String img = request.getParameter("txtImg");
        String bookName = request.getParameter("txtBookName");
        String author = request.getParameter("txtBookAuthor");
        String price = (String)(request.getParameter("txtBookPrice"));
        String quantity = (String)request.getParameter("txtQuantity");
        try {
            if (bookID == null || bookID.length() < 2) {
                errorBook.setBookIDError("Book ID is not null");
                check = false;
            }else{
                errorBook.setBookIDError("✔");
            }
            
            if (bookName == null || bookName.length() < 2) {
                errorBook.setBookNameError("Book Name is not null and lenght > 2");
                check = false;
            }else{
                errorBook.setBookNameError("✔");
            }
            
            if (author == null || author.length() < 3) {
                errorBook.setAuthorError("Author is not null and lenght > 3");
                check = false;
            }else{
                errorBook.setAuthorError("✔");
            }
            
            if(price.length() <4 ){
                errorBook.setPriceError(" Price > 1000");
                check = false;
            }else{
                errorBook.setPriceError("✔");
            }
            
            if(quantity.length() <1 ){
                errorBook.setQuantityError(" Quantity > 0");
                check = false;
            }else{
                errorBook.setQuantityError("✔");
            }
            
            BookDAO dao = new BookDAO();
            boolean checkID = dao.checkExistedID(bookID);
            if (checkID) {
                errorBook.setBookIDError("Book is existed");
                checkID = false;
            }
            if (check) {

                BookDTO dto = new BookDTO(bookID, img,bookName, author, Integer.valueOf(price),Integer.valueOf(quantity));
                dao.insert(dto);
                url = OPTION;
            } else {
                request.setAttribute("ERROR_BOOK", errorBook);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                errorBook.setBookIDError("Book ID already existed");
                request.setAttribute("ERROR_BOOK", errorBook);
                
            }
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
