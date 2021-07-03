package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
}
