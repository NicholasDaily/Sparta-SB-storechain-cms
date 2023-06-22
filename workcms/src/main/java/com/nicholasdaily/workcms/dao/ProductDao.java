package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(int id);

    List<Product> getAllProducts();

    void createProduct(Product Product);

    Product updateProduct(Product Product);

    void deleteProduct(Product Product);

    void deleteProductById(int id);
}
