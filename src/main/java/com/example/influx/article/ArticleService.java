package com.example.influx.article;

import com.example.influx.article.dto.ArticleDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticlesWithoutComments() {
        return articleRepository.findAll();
    }

    public Article getArticleById(@PathVariable Long id) {
        return articleRepository.findById(id).orElseThrow();
    }

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional // w return moge usunac metode save bo hibernate sam sprwadza i zapisuje zedytowane pola encji
    public Article editArticle(Article article) {
        Article articleEdited = articleRepository.findById(article.getId()).orElseThrow();
        articleEdited.setContent(article.getContent());
        articleEdited.setTitle(article.getTitle());
        return articleEdited;
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
