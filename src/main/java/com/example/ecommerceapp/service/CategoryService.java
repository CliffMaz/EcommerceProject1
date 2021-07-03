package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Category;
import com.example.ecommerceapp.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo=categoryRepo;
    }

    public List<Category> getCategories(){
        return  categoryRepo.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }
}
