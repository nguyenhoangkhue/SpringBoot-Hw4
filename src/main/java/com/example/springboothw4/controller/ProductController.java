package com.example.springboothw4.controller;

import com.example.springboothw4.model.Product;
import com.example.springboothw4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "allProducts";
    }
    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable int id){
        Product product=productService.getProductById(id);
        model.addAttribute("product",product);
        return "id";
    }
    @GetMapping("/name-start/{prefix}")
    public String getProductByPrefix(Model model,@PathVariable String prefix){
        List<Product>searchByPrefix=productService.searchProduct(prefix);
        model.addAttribute("products",searchByPrefix);
        return "productsByPrefix";
    }
    @GetMapping("/price/{min}/{max}")
    public String getProductByPrice(Model model,@PathVariable int min,@PathVariable int max){
        List<Product> productsByPrice=productService.getProductsInRangePrice(min,max);
        model.addAttribute("products",productsByPrice);
        return "productsByPrice";
    }
    @GetMapping("/brand/{brand}")
    public String getProductByBrand(Model model,@PathVariable String brand){
        List<Product>searchByBrand=productService.searchByBrand(brand);
        model.addAttribute("products",searchByBrand);
        return "productsByBrand";
    }
    @GetMapping("/brand/{brand}/max-price")
    public String getMaxPriceProductOfBrand(Model model,@PathVariable String brand){
        Product product=productService.MaxPriceProductOfBrand(brand);
        model.addAttribute("product",product);
        return "maxPriceProductOfBrand";
    }
}