package com.wide.order.service;

import com.wide.order.entity.Product;
import com.wide.order.exception.ResourceNotFound;
import com.wide.order.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllActiveProducts() {
        return productRepository.findAllActiveProducts();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product payload) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + id));

        product.setName(payload.getName());
        product.setDescription(payload.getDescription());
        product.setStock(payload.getStock());
        product.setPrice(payload.getPrice());

        return productRepository.save(product);
    }

    @Override
    public void destroyProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + id));

        product.setDeletedAt(LocalDateTime.now());

        productRepository.save(product);
    }
}
