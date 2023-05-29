package com.example.influx.service;

import com.example.influx.repository.ArticleRepository;
import com.example.influx.entity.Article;
import com.example.influx.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private static final int PAGE_SIZE = 30;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public List<Article> getArticlesWithoutComments(int page, Sort.Direction sort) {
        return articleRepository.findAllArticles(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "dateAdded")));
    }

    public Article getArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow();
    }

//    public List<Article> getArticlesWithComments(int page, Sort.Direction sort) {
//        return articleRepository.findAllArticles(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "dateAdded")));
//    }

    public List<Article> getArticlesByUserAccount(Long userId) {
        return articleRepository.findArticlesByUserAccountId(userId);
    }

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    public Article editArticle(Article article) {
        Article articleEdited = articleRepository.findById(article.getId()).orElseThrow();
        articleEdited.setTitle(article.getTitle());
        articleEdited.setContent(article.getContent());
        articleEdited.setCategory(article.getCategory());
        return articleEdited;
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public List<Article> getArticlesByCategory(Long categoryId) {
        return articleRepository.findArticlesByCategoryId(categoryId);
    }
}

