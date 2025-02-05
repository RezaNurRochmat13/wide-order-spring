package com.wide.order.service;

import com.wide.order.entity.Customer;

import java.util.List;

public interface ArticleService {
    List<Customer> findAllArticles();
    Customer findArticleById(Long id);
    Customer createArticle(Customer article);
    Customer updateArticle(Long id, Customer article);
    void deleteArticle(Long id);
}
