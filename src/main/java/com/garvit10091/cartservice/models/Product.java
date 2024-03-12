package com.garvit10091.cartservice.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private long productId;
    private long quantity;

    public Product() {
    }
    public Product(long id, long quantity) {
        this.productId = id;
        this.quantity = quantity;
    }
}
