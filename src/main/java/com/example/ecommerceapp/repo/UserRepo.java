package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

   // User getCurrentlyLoggedInUser(@AuthenticationPrincipal Authentication auth);
}
