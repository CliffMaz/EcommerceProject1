package com.example.ecommerceapp.security;

import com.example.ecommerceapp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CUserDetails implements UserDetails {

    User user;


    public CUserDetails(User user) {
        super();
        this.user =user;
    }
    public CUserDetails(){


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities =new ArrayList<>();

        return Arrays.stream(this.user.getRole().split(","))
                .map(role-> new SimpleGrantedAuthority("ROLE_"+role))
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
