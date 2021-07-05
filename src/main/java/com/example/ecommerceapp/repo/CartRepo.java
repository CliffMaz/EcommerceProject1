package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);


    //Cart updateQuantityByCartId();
}
