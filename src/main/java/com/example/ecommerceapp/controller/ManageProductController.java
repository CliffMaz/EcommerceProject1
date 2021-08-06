package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Category;
import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.service.CategoryService;
import com.example.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("productManagement")
public class ManageProductController {
    private List<Product> products=new ArrayList<>();
    public final ProductService pService;
    public final CategoryService categoryService;

    @Autowired
    public ManageProductController(ProductService pService, CategoryService categoryService){

        this.pService=pService;
        this.categoryService=categoryService;
    }

    @GetMapping
    public String getAllProducts(Model model){

        List<Product> allProducts=pService.getAllProducts();
        List<Category> categoryList=categoryService.getCategories();
        model.addAttribute("editProduct",products);
        model.addAttribute("productLists",allProducts);
        model.addAttribute("categoryList",categoryList);

        return "manageProducts";

    }


}