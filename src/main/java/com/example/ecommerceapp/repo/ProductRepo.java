package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{


   // void deleteProductById(Integer id);


    // Product updateProduct();
}
