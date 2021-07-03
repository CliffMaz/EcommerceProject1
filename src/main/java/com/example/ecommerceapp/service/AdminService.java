package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Admin;
import com.example.ecommerceapp.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo){
        this.adminRepo=adminRepo;
    }

    public Admin addAdmin(Admin admin){
       return adminRepo.save(admin);
    }
}
