package com.example.demo.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired()
    ProductRepository productRepository;


    public void createProduct(){
        var product = new Product("hammasharja", 5);

        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
