package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepo;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public Product postProduct(Product obj){
        return productRepo.save(obj);
    }
    public List<Product> getAllProducts()
    {
        return productRepo.findAll();
    }
    public Optional<Product> getProductById(Integer productId)
    {
        return productRepo.findById(productId);
    }
}

mm