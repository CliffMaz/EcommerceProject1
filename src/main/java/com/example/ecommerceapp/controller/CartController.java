package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.service.CartService;
import com.example.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoppingCart")
public class CartController {
    /*@Autowired
       CartService cartService;

    @Autowired
    UserService userService;


    public CartController(CartService cartService, UserService userService){

           this.cartService=cartService;
           this.userService=userService;
       }
*/
      @GetMapping("/getCart")
    public String getCart(Model model, @AuthenticationPrincipal Authentication auth){

        //String user = userService.getCurrentlyLoggedInUser(auth);
           //cartService.getCartByUserId(user);
           return "ShoppingCart";
      }
}
