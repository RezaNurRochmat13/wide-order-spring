package com.wide.order.service;

import com.wide.order.entity.Product;
import com.wide.order.entity.dto.product.CreateProductDto;
import com.wide.order.entity.dto.product.ListProductDto;
import com.wide.order.entity.dto.product.SingleProductDto;
import com.wide.order.entity.dto.product.UpdateProductDto;

import java.util.List;

public interface ProductService {
    List<ListProductDto> findAllActiveProducts();
    SingleProductDto findProductById(Long id);
    Product createProduct(CreateProductDto payload);
    Product updateProduct(Long id, UpdateProductDto payload);
    void destroyProduct(Long id);
}
