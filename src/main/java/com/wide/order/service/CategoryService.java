package com.wide.order.service;

import com.wide.order.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void destroyCategory(Long id);
}
