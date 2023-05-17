package com.example.influx.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

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

    @PutMapping("/articles")
    public Article editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

}
