package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.repo.UserRepo;
import com.example.ecommerceapp.security.CUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserRepo userRepo;

    public UserService(UserRepo userRepo){

        this.userRepo=userRepo;
    }


public User getCurrentlyLoggedInUser(@AuthenticationPrincipal Authentication auth){


    Object principal= auth.getPrincipal();
    log.info("yey: "+((CUserDetails) principal).getUsername());
    User user=null;
        if(auth==null) return null;

            log.info("Clifford not null........");
            if(principal instanceof CUserDetails){

                user= userRepo.findUserByUsername(((CUserDetails) principal).getUsername());
            }
            return user;


}
}
