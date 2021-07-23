package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    CartRepo cartRepo;


    @Autowired
    public CartService(CartRepo cartRepo){
        this.cartRepo=cartRepo;

    }

    public List<Cart> getCartByUser(User user){

        return cartRepo.findByUser(user);
    }

    public Cart AddProduct(Cart cart){

        return cartRepo.save(cart);
    }

    public  List<Cart> updateQuantityById(Integer qty, Integer cart_id, User user){

         cartRepo.updateQuantityByCartId(qty,cart_id, user.getUserId());
         return cartRepo.findByUser(user);
    }

}