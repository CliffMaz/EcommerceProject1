package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Category;
import com.example.ecommerceapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("/all")
    public String getAllCategories(Model model){
        List<Category> categoryList= categoryService.getCategories();
        model.addAttribute("categories",categoryList);

        return "manageCategory";
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCat=categoryService.addCategory(category);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED);
    }
}