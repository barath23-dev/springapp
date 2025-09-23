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
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService ps;

    @PostMapping("/api/product")
    public ResponseEntity<Product> create(@RequestBody Product p)
    {
        Product obj=ps.create(p);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping("/api/product/{offset}/{pagesize}")
    public List<Product> get(@PathVariable int offset, @PathVariable int pagesize)
    {
    return ps.page(pagesize,offset);
    }
   
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
        public List<Product> getsorting(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field)
        {
            return ps.getsort(offset,pagesize,field);
        }
 
    @GetMapping("/api/product/{productId}")
        public ResponseEntity<Product> getProductById(@PathVariable int productId){
        Optional<Product> p = ps.getProductById(productId);
        if(p.isPresent()){
            return new ResponseEntity<Product>(p.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   
}
}
