package com.example.testfinal.services;

import com.example.testfinal.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

}
