package com.example.ecommerceapp.security;

import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public CUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user " + username + " not found");
        }else {
            return new CUserDetails(user);
        }
    }
}