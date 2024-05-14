package com.example.springboothw4.dao.impl;

import com.example.springboothw4.dao.ProductDAO;
import com.example.springboothw4.database.ProductDB;
import com.example.springboothw4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDaoimpl implements ProductDAO {
    @Override
    public List<Product> findAll(){
        return ProductDB.products;
    }
    @Override
    public Product findByID(int id){
        return findAll().stream()
                .filter(product -> product.getId()==(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Product>searchProduct(String prefix){
        return findAll().stream()
                .filter(product -> product.getName().startsWith(prefix))
                .collect(Collectors.toList());
    }
    @Override
    public List<Product>getProductsInRangePrice(int min,int max){
        return findAll().stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .collect(Collectors.toList());
    }
    @Override
    public List<Product>searchByBrand(String brand){
        return findAll().stream()
                .filter(product -> product.getBrand().equals(brand))
                .collect(Collectors.toList());
    }
    @Override
    public Product MaxPriceProductOfBrand(String brand){
        return searchByBrand(brand).stream()
                .max((p1, p2) -> p1.getPrice() - p2.getPrice())
                .orElse(null);
    }
}
