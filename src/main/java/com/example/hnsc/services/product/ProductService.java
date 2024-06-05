package com.example.hnsc.services.product;

import com.example.hnsc.models.Product;
import com.example.hnsc.repositories.product.IProductRepo;
import com.example.hnsc.repositories.product.ProductRepo;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    IProductRepo productRepo = new ProductRepo();
    @Override
    public List<Product> selectAll() {
        try {
            return productRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Product product) {
        try {
            productRepo.insert(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        try {
            return productRepo.selectProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            productRepo.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
