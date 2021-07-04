package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.repo.UserRepo;
import com.example.ecommerceapp.security.CUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    UserRepo userRepo;

    public UserService(UserRepo userRepo){

        this.userRepo=userRepo;
    }

/*
public String getCurrentlyLoggedInUser( Authentication auth){

        Long user=null;
        Object principal= auth.getPrincipal();
        if(auth==null){

            return null;
        }else{

            if(principal instanceof CUserDetails){
                user= ((CUserDetails) principal).;
            }
            return user;
        }

}*/
}
