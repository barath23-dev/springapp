package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo pr;
   
    public Product create(Product p)
    {
        return pr.save(p);
    }

    public List<Product> page(int pageSize, int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber,pageSize);
        return pr.findAll(page).getContent();  
     }
   
     public List<Product> getsort(int pageNumber, int pageSize, String field)
     {
        return pr.findAll(PageRequest.of(pageNumber,pageSize).withSort(Sort.by(Sort.Direction.ASC, field))).getContent();
     }

       public Optional<Product> getProductById(Integer productId)
    {
        return pr.findById(productId);
    }

}
