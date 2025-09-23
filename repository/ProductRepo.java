package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
   
}
