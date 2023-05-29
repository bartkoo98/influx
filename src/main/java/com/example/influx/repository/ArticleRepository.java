package com.example.influx.repository;

import com.example.influx.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findById(Long id);
    @Query("Select a From Article a" +
            " left join fetch a.comments")
    List<Article> findAllArticles(Pageable pageable);

    Article save(Article article);

    List<Article> findArticlesByUserAccountId(Long userId);
    List<Article> findArticlesByCategoryId(Long categoryId);
}
