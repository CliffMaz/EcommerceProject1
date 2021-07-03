package com.example.ecommerceapp.controller;


import com.example.ecommerceapp.model.Product;
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
@RequestMapping("/product")
public class ProductController {

    public final ProductService pService;

    @Autowired
    public ProductController(ProductService pService){

        this.pService=pService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model){

        List<Product> allProducts=pService.getAllProducts();

         model.addAttribute("productList",allProducts);

       return "product";

    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product p= pService.addProduct(product);
        return new ResponseEntity<>(p, HttpStatus.OK);

    }

   // @PutMapping("/update")
    //public String updateProduct(@RequestBody Product product){
      //  Product ToUpdate= pService.updateProduct();
        //return "addProduct";

    //}
}
