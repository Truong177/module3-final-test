package com.example.testfinal.services.impl;

import com.example.testfinal.models.Product;
import com.example.testfinal.repositories.IProductRepository;
import com.example.testfinal.repositories.impl.ProductRepository;
import com.example.testfinal.services.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

}
