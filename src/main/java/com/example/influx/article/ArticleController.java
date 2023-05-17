package com.example.influx.article;

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
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
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
