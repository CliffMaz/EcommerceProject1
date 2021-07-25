package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Category;
import com.example.ecommerceapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getCategory")
public class CategoryRestController {


    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController( CategoryService categoryService){

        this.categoryService=categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCat=categoryService.addCategory(category);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED);
    }

}
