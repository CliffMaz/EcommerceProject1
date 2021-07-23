package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.service.CartService;
import com.example.ecommerceapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class CartRestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;


    public CartRestController(CartService cartService, UserService userService){

        this.cartService=cartService;
        this.userService=userService;

    }



    @PutMapping("/update/{qty}/{cart_id}")
    public String updateCart(@PathVariable("qty") Integer qty,
                             @PathVariable("cart_id") Integer cart_id){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        if(auth==null || auth instanceof AnonymousAuthenticationToken){
            return "User needs to be logged in";
        }
        User user=userService.getCurrentlyLoggedInUser(auth);


        cartService.updateQuantityById(qty,cart_id, user);
        return "ShoppingCart";
    }
}
