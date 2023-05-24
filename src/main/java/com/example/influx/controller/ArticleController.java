package com.example.influx.controller;

import com.example.influx.entity.Article;
import com.example.influx.mapper.ArticleMapper;
import com.example.influx.service.ArticleService;
import com.example.influx.dto.ArticleDto;
import com.example.influx.dto.ArticleWithoutCommentsDto;
import com.example.influx.entity.Comment;
import com.example.influx.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;

    @GetMapping("/articles")
    public List<ArticleWithoutCommentsDto> getArticlesWithoutComments() {
        return ArticleMapper.mapToArticleWithoutCommentsDtos(articleService.getArticlesWithoutComments());
    }

    @GetMapping("/articles/{id}")
    public ArticleDto getArticleById(@PathVariable Long id) {
        return ArticleMapper.mapToArticleDtos(articleService.getArticleById(id));
    }

    @GetMapping("/articles/category/{id}")
    public List<ArticleWithoutCommentsDto> getArticlesWithoutCommentsByCategory(@PathVariable Long id) {
        return ArticleMapper.mapToArticleWithoutCommentsDtos(articleService.getArticlesWithoutCommentsByCategoryId(id));
    }


    @PostMapping("/articles")
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @PutMapping("/articles/{id}")
    public Article editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    @GetMapping("/articles/{id}/comments")
    public List<Comment> getAllCommentsForArticle(@PathVariable Long id) {
        return commentService.getAllCommentsForArticle(id);
    }


}
