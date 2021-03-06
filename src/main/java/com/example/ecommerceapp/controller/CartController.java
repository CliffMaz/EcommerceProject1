package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.Product;
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

@Controller
@RequestMapping("/shoppingCart")
public class CartController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
       CartService cartService;

    @Autowired
    UserService userService;


    public CartController(CartService cartService, UserService userService){

           this.cartService=cartService;
           this.userService=userService;

       }

      @GetMapping("/getCart")
    public Object getCart(Model model, Authentication auth){

        User user = userService.getCurrentlyLoggedInUser(auth);

          List<Cart>  shoppingList=cartService.getCartByUser(user);
          model.addAttribute("myCart",shoppingList);

           return "ShoppingCart";
      }


}
