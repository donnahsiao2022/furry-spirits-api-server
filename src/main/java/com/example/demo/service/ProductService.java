package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }
}
