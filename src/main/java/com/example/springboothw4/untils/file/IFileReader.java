package com.example.springboothw4.untils.file;

import com.example.springboothw4.model.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String filePath);
}
