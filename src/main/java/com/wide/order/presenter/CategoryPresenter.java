package com.wide.order.presenter;

import com.wide.order.entity.Category;
import com.wide.order.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class CategoryPresenter {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("categories")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findAllCategories() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", categoryService.findAllCategories());
        return response;
    }

    @GetMapping("categories/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> findCategoryById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", categoryService.findCategoryById(id));
        return response;
    }

    @PostMapping("categories")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Map<String, Object> createCategory(@RequestBody Category category) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", categoryService.createCategory(category));
        return response;
    }

    @PutMapping("categories/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> updateCategory(@PathVariable Long id, @RequestBody Category payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", categoryService.updateCategory(id, payload));
        return response;
    }

    @DeleteMapping("categories/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Map<String, Object> destroyCategory(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        categoryService.destroyCategory(id);
        return response;
    }
}
