package com.garvit10091.cartservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Cart {

    private long id;
    private long userId;
    private String date;
    private List<Product> products;

    public Cart() {
    }

    public Cart(long id, long userId, String date, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = products;
    }
}
