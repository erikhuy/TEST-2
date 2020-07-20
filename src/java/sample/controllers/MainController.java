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

/**
 *
 * @author Duc Manh
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    public static final String ERROR = "invalid.html";
    public static final String LOGIN = "LoginController";
    public static final String SEARCH_USER = "SearchUserController";
    public static final String SEARCH_BOOK = "SearchBookController";
    public static final String SEARCH_BOOK_FOR_USER = "SearchBookForUserController";
    public static final String LOGOUT = "LogoutController";
    public static final String CHECK_OUT = "CheckOutController";
    public static final String BORROW = "BorrowController";
    public static final String REMOVE = "RemoveController";
    public static final String DELETE_USER = "DeleteUserController";
    public static final String DELETE_BOOK = "DeleteBookController";
    public static final String CREATE_USER = "CreateUserController";
    public static final String CREATE_BOOK = "CreateBookController";
    public static final String UPDATE_USER = "updateUser.jsp";
    public static final String UPDATE_USER_CONTROLLER = "UpdateUserController";
    public static final String UPDATE_BOOK = "updateBook.jsp";
    public static final String UPDATE_BOOK_CONTROLLER = "UpdateBookController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Search User")) {
                url = SEARCH_USER;
            } else if (action.equals("Search Book")) {
                url = SEARCH_BOOK;
            } else if (action.equals("|Search Book|")) {
                url = SEARCH_BOOK_FOR_USER;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
                } else if (action.equals("Check Out")) {
                url = CHECK_OUT;
            } else if (action.equals("Borrow")) {
                url = BORROW;
            } else if (action.equals("Remove")) {
                url = REMOVE;
            } else if (action.equals("Delete User")) {
                url = DELETE_USER;
            } else if (action.equals("Delete Book")) {
                url = DELETE_BOOK;
            } else if (action.equals("Create User")) {
                url = CREATE_USER;
            } else if (action.equals("Create Book")) {
                url = CREATE_BOOK;
            } else if (action.equals("Update_User")) {
                url = UPDATE_USER;
            } else if (action.equals("Update User")) {
                url = UPDATE_USER_CONTROLLER;
            } else if (action.equals("Update_Book")) {
                url = UPDATE_BOOK;
            } else if (action.equals("Update Book")) {
                url = UPDATE_BOOK_CONTROLLER;
            }

        } catch (Exception e) {
            Logger.getLogger("ERROR at MainController" + e.getMessage());
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
