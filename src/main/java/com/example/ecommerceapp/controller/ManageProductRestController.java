package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Product;
import com.example.ecommerceapp.service.CategoryService;
import com.example.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manageProduct")
public class ManageProductRestController {

    private List<Product> products=new ArrayList<>();
    private List<Product> allProducts=new ArrayList<>();
    public final ProductService pService;
    public final CategoryService categoryService;

    @Autowired
    public ManageProductRestController(ProductService pService, CategoryService categoryService){

        this.pService=pService;
        this.categoryService=categoryService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Integer id, Model model){

        Product product=pService.findProductById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("productForm") Product product, Model model){
        pService.addProduct(product);
        allProducts=pService.getAllProducts();
        model.addAttribute("productItem",allProducts);
        model.addAttribute("menu1","Management");
        return "manageProducts";

    }

   /* @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Integer id, Model model){

        pService.deleteProductById(id);
        allProducts=pService.getAllProducts();
        model.addAttribute("productList", allProducts);
    }*/
     @PostMapping("/update")
    public void updateProduct(@ModelAttribute("productFormEdit") Product product){
         System.out.println("siya tester: "+product.getProductId());
        Product toUpdate= pService.updateProductById(product);
      System.out.println("siya testa: "+product.getProductId());

    }
}
