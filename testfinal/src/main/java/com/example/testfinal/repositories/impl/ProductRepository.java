package com.example.testfinal.repositories.impl;

import com.example.testfinal.models.Product;
import com.example.testfinal.repositories.IProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(
                "SELECT id_product, name, price, discount, stock FROM product");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name");
                long price = resultSet.getLong("price");
                int discount = resultSet.getInt("discount");
                int stock = resultSet.getInt("stock");

                Product product = new Product(id, name, price, discount, stock);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving products", e);
        }
        return products;
    }

    @Override
    public void save(Product product) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("insert into product (name,price,discount,stock) values (?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setInt(3, product.getDiscount());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
