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
import sample.daos.UserDAO;
import sample.dtos.ErrorUserDTO;
import sample.dtos.UserDTO;

/**
 *
 * @author Huy
 */
@WebServlet(name = "CreateUserController", urlPatterns = {"/CreateUserController"})
public class CreateUserController extends HttpServlet {

    public static final String CREATE = "createUser.jsp";
    public static final String OPTION = "adminOption.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ErrorUserDTO errorUser = new ErrorUserDTO();
        String url = CREATE;
        try {

            String userID = request.getParameter("txtUserID");
            String userName = request.getParameter("txtUserName");
            String roleID = request.getParameter("txtRoleID");
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtRePassword");
            boolean check = true;
            if (userID == null || userID.length() < 1) {
                errorUser.setUserIDError("UserID is not null");
                check = false;
            }else{
                errorUser.setUserIDError("✔");
            }
            
            if (userName == null || userName.length() < 2) {
                errorUser.setUserNameError("UserName is not null and lenght > 2");
                check = false;
            }else{
                errorUser.setUserNameError("✔");
            }
            
            if (!rePassword.equals(password)) {
                errorUser.setRePasswordError("Not Macth !!!");
                check = false;
            }else{
                errorUser.setRePasswordError("✔");
            }
            
            if (password.length()< 3 ) {
                errorUser.setPasswordError("Password is not null and lenght > 3");
                check = false;
            }else{
                errorUser.setPasswordError("✔");
            }
            
            if (rePassword.length() < 3) {
                errorUser.setRePasswordError("RePassword is not null and lenght > 3");
                check = false;
            }else{
                errorUser.setRePasswordError("✔");
            }
            
            UserDAO dao = new UserDAO();
            boolean checkID= dao.checkExistedID(userID);
            if(checkID){
                errorUser.setUserIDError("User is existed");
                checkID= false;
            }
            if (check) {

                UserDTO dto = new UserDTO(userID, userName, password, roleID);
                dao.insert(dto);
                url = OPTION;
            } else {
                request.setAttribute("ERROR", errorUser);
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                errorUser.setUserIDError("UserID already existed");
                request.setAttribute("ERROR", errorUser);
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
