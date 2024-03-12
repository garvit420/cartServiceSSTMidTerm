package com.garvit10091.cartservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long productId;
    private long quantity;

    public FakeStoreProductDto() {
    }
    public FakeStoreProductDto(long id, long quantity) {
        this.productId = id;
        this.quantity = quantity;
    }
}
