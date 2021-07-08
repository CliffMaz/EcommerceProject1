package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.Cart;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser(User user);


    @Modifying
    @Query(" UPDATE Cart c SET c.quantity = ?1 WHERE c.cart_id = ?2 ")
    void updateQuantityByCartId(int quantity, Integer cId);
}
