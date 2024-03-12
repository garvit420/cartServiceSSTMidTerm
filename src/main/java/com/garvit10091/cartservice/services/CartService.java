package com.garvit10091.cartservice.services;

import com.garvit10091.cartservice.models.Cart;
import com.garvit10091.cartservice.models.Product;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getCartById(long userId);
    List<Cart> getCartsByDateRange(String start, String end);
    List<Cart> getCartsByUserId(long userId);
    Cart createCart(Cart cart);
    void updateCart(long id, Cart cart);
    void deleteCart(long id);
}
