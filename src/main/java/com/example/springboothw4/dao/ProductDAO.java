package com.example.springboothw4.dao;

import com.example.springboothw4.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product>findAll();
    Product findByID(int id);
    List<Product>searchProduct(String prefix);
    List<Product>getProductsInRangePrice(int min,int max);
    List<Product>searchByBrand(String brand);
    Product MaxPriceProductOfBrand(String brand);
}
