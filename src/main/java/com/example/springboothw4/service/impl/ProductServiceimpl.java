package com.example.springboothw4.service.impl;

import com.example.springboothw4.dao.ProductDAO;
import com.example.springboothw4.model.Product;
import com.example.springboothw4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product>getAllProducts(){
        return productDAO.findAll();
    }
    @Override
    public Product getProductById(int id){
        return productDAO.findByID(id);
    }
    @Override
    public List<Product> searchProduct(String prefix){
        return productDAO.searchProduct(prefix);
    }
    @Override
    public List<Product>getProductsInRangePrice(int min,int max){
        return productDAO.getProductsInRangePrice(min,max);
    }
    @Override
    public List<Product>searchByBrand(String brand){
        return productDAO.searchByBrand(brand);
    }
    @Override
    public Product MaxPriceProductOfBrand(String brand){
        return productDAO.MaxPriceProductOfBrand(brand);
    }
}
