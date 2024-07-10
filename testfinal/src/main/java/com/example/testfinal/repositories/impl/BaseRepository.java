package com.example.testfinal.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/prodcut_final_test";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "17072001";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("Database connection successful.");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private BaseRepository() {
    }

    public static Connection getConnection() {
        return connection;
    }
}