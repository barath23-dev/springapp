package com.example.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;
@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product/add")
    public ResponseEntity<Product> postProduct(@RequestBody Product obj){
        Product solution = productService.postProduct(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(solution);      
    }
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId){
        Optional<Product> product = productService.getProductById(productId);
        if(product.isPresent()){
            return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
