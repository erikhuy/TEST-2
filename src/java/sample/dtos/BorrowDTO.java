/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.util.Date;

/**
 *
 * @author Huy
 */
public class BorrowDTO {
    String userID,bookID;
    Date borrowDate;

    public BorrowDTO(String userID, String bookID, Date borrowDate) {
        this.userID = userID;
        this.bookID = bookID;
        this.borrowDate = borrowDate;

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }


    
}
