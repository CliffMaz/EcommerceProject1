package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.service.CategoryService;
import com.example.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manageProduct")
public class ManageProductRestController {

    public final ProductService pService;
    public final CategoryService categoryService;

    @Autowired
    public ManageProductRestController(ProductService pService, CategoryService categoryService){

        this.pService=pService;
        this.categoryService=categoryService;
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("productForm") Product product, Model model){
        pService.addProduct(product);
        List<Product> allProducts=pService.getAllProducts();
        model.addAttribute("productList",allProducts);
        model.addAttribute("menu1","Management");
        return "manageProducts";

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){

        pService.deleteProductById(id);

    }
    // @PutMapping("/update")
    //public String updateProduct(@RequestBody Product product){
    //  Product ToUpdate= pService.updateProduct();
    //return "addProduct";

    //}
}
