package com.wide.order.service;

import com.wide.order.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllActiveProducts();
    Product findProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product payload);
    void destroyProduct(Long id);
}
