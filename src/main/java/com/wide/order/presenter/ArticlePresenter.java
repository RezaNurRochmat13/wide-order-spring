package com.wide.order.presenter;

import com.wide.order.entity.Customer;
import com.wide.order.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticlePresenter {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping
    public Map<String, Object> getAllArticles() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", articleService.findAllArticles());
        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getArticleById(Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", articleService.findArticleById(id));
        return response;
    }

    @PostMapping
    public Map<String, Object> createArticle(@RequestBody Customer article) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", articleService.createArticle(article));
        return response;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateArticle(@PathVariable Long id, @RequestBody Customer article) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", articleService.updateArticle(id, article));
        return response;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteArticle(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        articleService.deleteArticle(id);
        return response;
    }
}
