package com.garvit10091.cartservice.controllers;

import com.garvit10091.cartservice.models.Cart;
import com.garvit10091.cartservice.services.CartService;
import com.garvit10091.cartservice.models.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts(){

        return cartService.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getCartById(@PathVariable("id") long id){
        return cartService.getCartById(id);
    }

    @GetMapping("/carts/{startDate}/{endDate}")
    public List<Cart> getCartsByDateRange(@PathVariable("startDate") String start, @PathVariable("endDate") String end){
        return cartService.getCartsByDateRange(start, end);
    }

    @GetMapping("/carts/user/{userId}")
    public List<Cart> getCartsByUserId(@PathVariable("userId") long userId){
        return cartService.getCartsByUserId(userId);
    }

    @PostMapping("/carts")
    public Cart createCart(@RequestBody Cart cart){

        return cartService.createCart(cart);
    }

    @PutMapping("/carts/{id}")
    public void updateCart(@PathVariable("id") long id, @RequestBody Cart cart){
        cartService.updateCart(id, cart);
    }

    @DeleteMapping("/carts/{id}")
    public void deleteCart(@PathVariable("id") long id){
        cartService.deleteCart(id);
    }

}
