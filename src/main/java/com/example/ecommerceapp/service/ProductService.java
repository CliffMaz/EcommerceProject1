package com.example.ecommerceapp.service;

import com.example.ecommerceapp.repo.ProductRepo;
import com.example.ecommerceapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    ProductRepo pRepo;

    @Autowired
    public ProductService(ProductRepo pRepo){

        this.pRepo=pRepo;

    }

    public List<Product> getAllProducts(){

        return pRepo.findAll();
    }

    public Product addProduct(Product product){
       return pRepo.save(product);
    }

   // public Product updateProduct(){
   //     return pRepo.updateProduct();
   // }
}
