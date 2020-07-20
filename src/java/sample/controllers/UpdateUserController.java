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
import sample.daos.UserDAO;
import sample.dtos.ErrorUserDTO;
import sample.dtos.UserDTO;

/**
 *
 * @author Huy
 */
@WebServlet(name = "UpdateUserController", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {

    public static final String ERROR = "updateUser.jsp";
    public static final String SUCCESS = "SearchUserController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ErrorUserDTO errorUser = new ErrorUserDTO();
        try {
            String userID = request.getParameter("txtUserID");
            String userName = request.getParameter("txtUserName");
            String roleID = request.getParameter("txtRoleID");
            String password = request.getParameter("txtPassword");
            boolean check = true;

            if (userName == null || userName.length() < 2) {
                errorUser.setUserNameError("UserName is not null and lenght > 2");
                check = false;
            } else {
                errorUser.setUserNameError("✔");
            }

            if (password.length() < 3) {
                errorUser.setPasswordError("Password is not null and lenght > 3");
                check = false;
            } else {
                errorUser.setPasswordError("✔");
            }
            UserDAO dao = new UserDAO();
            if (check) {
                UserDTO dto = new UserDTO(userID, userName, password, roleID);
                dao.update(dto);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_USER", errorUser);
            }
        } catch (Exception e) {
            request.setAttribute("ERROR_USER", errorUser);
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
            Logger.getLogger(UpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
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
