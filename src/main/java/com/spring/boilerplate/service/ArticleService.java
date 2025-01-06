package com.spring.boilerplate.service;

import com.spring.boilerplate.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAllArticles();
    Article findArticleById(Long id);
    Article createArticle(Article article);
    Article updateArticle(Long id, Article article);
    void deleteArticle(Long id);
}
