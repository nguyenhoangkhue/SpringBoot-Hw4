package com.example.springboothw4.service;

import com.example.springboothw4.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    List<Product> searchProduct(String prefix);
    List<Product> getProductsInRangePrice(int min, int max);
    List<Product> searchByBrand(String brand);
    Product MaxPriceProductOfBrand(String brand);
}
