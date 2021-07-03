package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
