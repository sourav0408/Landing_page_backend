package com.example.landing_page.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/testConnection")
    public String testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "Database connection is successful!";
        } catch (SQLException e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}