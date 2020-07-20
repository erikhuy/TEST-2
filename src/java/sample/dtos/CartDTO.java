/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Huy
 */
public class CartDTO {

    private Map<String, BookDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public void add(BookDTO dto) {
        if (this.cart == null) {
            cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getBookID())) {
            int quantity = this.cart.get(dto.getBookID()).getQuantity();
            dto.setQuantity(quantity + 1);
        }
        cart.put(dto.getBookID(), dto);
    }

    public void delete(String ID) {
        if (cart == null) {
            return;
        }
        if (this.cart.containsKey(ID)) {
            this.cart.remove(ID);
        }
    }

    public void update(String ID, BookDTO dto) {
        if (this.cart != null) {
            if (this.cart.containsKey(ID)) {
                this.cart.replace(ID, dto);
            }
        }
    }
}
