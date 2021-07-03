package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {


    Cart updateQuantityByCartId();
}
