/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

/**
 *
 * @author Duc Manh
 */
public class ErrorUserDTO {
    private String userIDError, userNameError, passwordError, roleIDError,rePasswordError;

    public ErrorUserDTO() {
    }


    public ErrorUserDTO(String userIDError, String userNameError, String passwordError, String roleIDError, String rePasswordError) {
        this.userIDError = userIDError;
        this.userNameError = userNameError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
        this.rePasswordError = rePasswordError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getRePasswordError() {
        return rePasswordError;
    }

    public void setRePasswordError(String rePasswordError) {
        this.rePasswordError = rePasswordError;
    }


            
    
}
