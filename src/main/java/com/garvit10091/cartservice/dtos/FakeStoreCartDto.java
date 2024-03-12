package com.garvit10091.cartservice.dtos;

import com.garvit10091.cartservice.models.Product;
import com.garvit10091.cartservice.services.FakeStoreCartService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartDto {
    private long id;
    private long userId;
    private String date;
    private List<FakeStoreProductDto> products;

    public FakeStoreCartDto() {
    }

    public FakeStoreCartDto(long id, long userId, String date, long productId, long quantity) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = List.of(new FakeStoreProductDto(productId, quantity));
    }

}
