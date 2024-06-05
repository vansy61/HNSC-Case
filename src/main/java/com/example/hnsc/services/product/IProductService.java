package com.example.hnsc.services.product;

import com.example.hnsc.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    void insert(Product product);
    Product selectProduct(int id);
    void delete(int id);
}
