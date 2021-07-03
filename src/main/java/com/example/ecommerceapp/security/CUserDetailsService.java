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
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = Optional.ofNullable((userRepo.findUserByUsername(username)));
        user.orElseThrow(() -> new UsernameNotFoundException("user "+username+" not found"));

        return user.map(CUserDetails::new).get();



    }
}
