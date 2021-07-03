package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final CartRepo cartRepo;

    @Autowired
    public CartService(CartRepo cartRepo){
        this.cartRepo=cartRepo;
    }

    public Optional<Cart> getCartByID(Long id){

       return cartRepo.findById(id);
    }

    public Cart AddProduct(Cart cart){

        return cartRepo.save(cart);
    }

    public  Cart updateQuantityById(){

        return cartRepo.updateQuantityByCartId();
    }
}
