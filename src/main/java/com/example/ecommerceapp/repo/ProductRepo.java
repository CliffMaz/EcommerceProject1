package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long>{

   // Product updateProduct();
}
