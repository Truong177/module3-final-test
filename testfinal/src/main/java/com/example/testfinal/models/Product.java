package com.example.testfinal.models;

public class Product {
    private int id_product;
    private String name;
    private Long price;
    private int discount;
    private int stock;

    public Product() {
    }

    public Product(String name, Long price, int discount, int stock) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public Product(int id_product, String name, Long price, int discount, int stock) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
