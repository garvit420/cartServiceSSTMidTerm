package com.garvit10091.cartservice.services;

import com.garvit10091.cartservice.dtos.FakeStoreCartDto;
import com.garvit10091.cartservice.dtos.FakeStoreProductDto;
import com.garvit10091.cartservice.models.Cart;
import com.garvit10091.cartservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCartService implements CartService{

    RestTemplate restTemplate = new RestTemplate();

    private Cart covertToCart(FakeStoreCartDto fakeStoreCartDto) {
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());

        if (fakeStoreCartDto.getProducts() != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreCartDto.getProducts()) {
                products.add(new Product(fakeStoreProductDto.getProductId(), fakeStoreProductDto.getQuantity()));
            }
            cart.setProducts(products);
        }

        return cart;
    }

    private FakeStoreCartDto covertToFakeStoreCartDto(Cart cart) {
        FakeStoreCartDto fakeStoreCartDto = new FakeStoreCartDto();
        fakeStoreCartDto.setId(cart.getId());
        fakeStoreCartDto.setUserId(cart.getUserId());
        fakeStoreCartDto.setDate(cart.getDate());

        if (cart.getProducts() != null) {
            List<FakeStoreProductDto> fakeStoreProductDtos = new ArrayList<>();
            for (Product product : cart.getProducts()) {
                fakeStoreProductDtos.add(new FakeStoreProductDto(product.getProductId(), product.getQuantity()));
            }
            fakeStoreCartDto.setProducts(fakeStoreProductDtos);
        }

        return fakeStoreCartDto;
    }

    @Override
    public List<Cart> getAllCarts() {
        FakeStoreCartDto[] fakeStoreCartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                FakeStoreCartDto[].class
        );

        if (fakeStoreCartDtos != null) {
            List<Cart> carts = new ArrayList<>();
            for (FakeStoreCartDto fakeStoreProductDto : fakeStoreCartDtos) {
                Cart cart = covertToCart(fakeStoreProductDto);
                carts.add(cart);
            }
            return carts;
        }

        return null;
    }

    @Override
    public Cart getCartById(long id) {
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + id,
                FakeStoreCartDto.class
        );

        if (fakeStoreCartDto != null) {
            return covertToCart(fakeStoreCartDto);
        }

        return null;
    }

    @Override
    public List<Cart> getCartsByDateRange(String start, String end) {
        FakeStoreCartDto[] fakeStoreCartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate=" + start + "&enddate=" + end,
                FakeStoreCartDto[].class
        );

        if (fakeStoreCartDtos != null) {
            List<Cart> carts = new ArrayList<>();
            for (FakeStoreCartDto fakeStoreProductDto : fakeStoreCartDtos) {
                Cart cart = covertToCart(fakeStoreProductDto);
                carts.add(cart);
            }
            return carts;
        }
        return null;
    }

    @Override
    public List<Cart> getCartsByUserId(long userId) {
        FakeStoreCartDto[] fakeStoreCartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/" + userId,
                FakeStoreCartDto[].class
        );

        if (fakeStoreCartDtos != null) {
            List<Cart> carts = new ArrayList<>();
            for (FakeStoreCartDto fakeStoreProductDto : fakeStoreCartDtos) {
                Cart cart = covertToCart(fakeStoreProductDto);
                carts.add(cart);
            }
            return carts;
        }
        return null;
    }

    @Override
    public Cart createCart(Cart cart) {
        FakeStoreCartDto fakeStoreCartDto = covertToFakeStoreCartDto(cart);
        restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                fakeStoreCartDto,
                FakeStoreCartDto.class
        );
        return cart;
    }

    @Override
    public void updateCart(long id, Cart cart) {
        FakeStoreCartDto fakeStoreCartDto = covertToFakeStoreCartDto(cart);
        restTemplate.put(
                "https://fakestoreapi.com/carts/" + id,
                fakeStoreCartDto,
                FakeStoreCartDto.class
        );
    }

    @Override
    public void deleteCart(long id) {
        restTemplate.delete("https://fakestoreapi.com/carts/" + id);
    }
}
