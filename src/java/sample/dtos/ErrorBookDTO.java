/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

/**
 *
 * @author Huy
 */
public class ErrorBookDTO {
    String bookIDError,bookNameError,authorError,priceError,quantityError;

    public ErrorBookDTO() {
    }

    public ErrorBookDTO(String bookIDError, String bookNameError, String authorError, String priceError,String quantityError) {
        this.bookIDError = bookIDError;
        this.bookNameError = bookNameError;
        this.authorError = authorError;
        this.priceError = priceError;
        this.quantityError = quantityError;
    }

    public String getBookIDError() {
        return bookIDError;
    }

    public void setBookIDError(String bookIDError) {
        this.bookIDError = bookIDError;
    }

    public String getBookNameError() {
        return bookNameError;
    }

    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }

    public String getAuthorError() {
        return authorError;
    }

    public void setAuthorError(String authorError) {
        this.authorError = authorError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    




    
}
