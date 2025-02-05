package com.wide.order.service;

import com.wide.order.entity.Customer;
import com.wide.order.exception.ResourceNotFound;
import com.wide.order.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Customer> findAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Customer findArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Article not found with id " + id));
    }

    @Override
    public Customer createArticle(Customer article) {
        return articleRepository.save(article);
    }

    @Override
    public Customer updateArticle(Long id, Customer article) {
        Customer existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Article not found with id " + id));

        existingArticle.setTitle(article.getTitle());
        existingArticle.setDescription(article.getDescription());
        existingArticle.setContent(article.getContent());
        existingArticle.setAuthor(article.getAuthor());

        return articleRepository.save(existingArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        Customer existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Article not found with id " + id));

        existingArticle.setDeletedAt(LocalDateTime.now());
        articleRepository.save(existingArticle);
    }
}
