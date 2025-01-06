package com.spring.boilerplate.presenter;

import com.spring.boilerplate.entity.Article;
import com.spring.boilerplate.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticlePresenter {

    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.findAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(Long id) {
        return articleService.findArticleById(id);
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
