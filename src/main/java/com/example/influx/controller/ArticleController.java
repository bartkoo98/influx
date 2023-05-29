package com.example.influx.controller;

import com.example.influx.entity.Article;
import com.example.influx.entity.UserAccount;
import com.example.influx.mapper.ArticleMapper;
import com.example.influx.service.ArticleService;
import com.example.influx.dto.ArticleDto;
import com.example.influx.dto.ArticleWithoutCommentsDto;
import com.example.influx.entity.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

import static com.example.influx.mapper.ArticleMapper.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleWithoutCommentsDto> getArticlesWithoutComments(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return mapToArticleWithoutCommentsDtos(articleService.getArticlesWithoutComments(pageNumber, sortDirection));
    }


    @GetMapping("/{id}")
    public ArticleDto getArticleById(@PathVariable Long id) {
        return mapToArticleDto(articleService.getArticle(id));
    }

    @GetMapping("/users/{userId}")
    public List<Article> getArticlesByUser(@PathVariable Long userId) {
        return articleService.getArticlesByUserAccount(userId);
    }
    @GetMapping("/categories/{categoryId}")
    public List<Article> getArticlesByCategory(@PathVariable Long categoryId) {
        return articleService.getArticlesByCategory(categoryId);
    }


    @PostMapping
    public Article addArticle(@RequestBody Article article){
        return articleService.addArticle(article);
    }

    @PutMapping
    public Article editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
