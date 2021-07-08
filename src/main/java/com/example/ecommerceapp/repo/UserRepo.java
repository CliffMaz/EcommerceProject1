package com.example.ecommerceapp.repo;

import com.example.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

   // User getCurrentlyLoggedInUser(@AuthenticationPrincipal Authentication auth);
}
