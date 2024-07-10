package com.example.testfinal.repositories;

import com.example.testfinal.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

}
