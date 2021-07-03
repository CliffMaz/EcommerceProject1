package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {

}
