package com.wide.order.service;

import com.wide.order.entity.Category;
import com.wide.order.exception.ResourceNotFound;
import com.wide.order.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAllActiveCategories();
    }

    @Override
    public Category findCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category noy found for this id :" + id));

        return category;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category payload) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category noy found for this id :" + id));

        category.setName(payload.getName());
        category.setDescription(payload.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public void destroyCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category noy found for this id :" + id));

        category.setDeletedAt(LocalDateTime.now());

        categoryRepository.save(category);
    }
}
