package com.wide.order.presenter;

import com.wide.order.entity.Product;
import com.wide.order.entity.dto.product.CreateProductDto;
import com.wide.order.entity.dto.product.UpdateProductDto;
import com.wide.order.service.ProductServiceImpl;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductPresenter {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("products")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findAllProducts() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", productService.findAllActiveProducts());
        return response;
    }

    @GetMapping("products/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findProductById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", productService.findProductById(id));
        return response;
    }

    @PostMapping("products")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Map<String, Object> createProduct(@RequestBody CreateProductDto payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", productService.createProduct(payload));
        return response;
    }

    @PutMapping("products/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> updateProduct(@PathVariable Long id, @RequestBody UpdateProductDto payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", productService.updateProduct(id, payload));
        return response;
    }

    @DeleteMapping("products/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Map<String, Object> destroyProduct(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        productService.destroyProduct(id);
        return response;
    }
}
