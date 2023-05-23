package com.example.influx.article;

import com.example.influx.article.dto.ArticleDto;
import com.example.influx.article.dto.ArticleWithoutCommentsDto;
import com.example.influx.comment.Comment;
import com.example.influx.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
