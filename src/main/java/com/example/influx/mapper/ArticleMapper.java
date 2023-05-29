package com.example.influx.mapper;

import com.example.influx.dto.ArticleDto;
import com.example.influx.dto.ArticleWithoutCommentsDto;
import com.example.influx.entity.Article;
import com.example.influx.entity.Comment;
import com.example.influx.dto.CommentDto;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleMapper {

    public static List<ArticleWithoutCommentsDto> mapToArticleWithoutCommentsDtos(List<Article> articles) {
        return  articles.stream()
                .map(ArticleMapper::mapToArticleWithoutCommentsDto)
                .toList();
    }

    private static ArticleWithoutCommentsDto mapToArticleWithoutCommentsDto(Article article) {
        var category = article.getCategory();
        var userAccount = article.getUserAccount();
        return ArticleWithoutCommentsDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .category(category.getId())
                .dateAdded(article.getDateAdded())
                .userAccount(userAccount.getEmail())
                .build();
    }

    public static List<ArticleDto>  mapToArticleDtos(List<Article> articles) {
     return articles.stream()
                .map(ArticleMapper::mapToArticleDto)
                .toList();

    }



    public static ArticleDto mapToArticleDto(Article article) {
        var category = article.getCategory();
        var userAccount = article.getUserAccount();
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .category(category.getId())
                .dateAdded(article.getDateAdded())
                .comments(mapFromComments(article.getComments()))
                .userAccount(userAccount.getEmail())
                .build();
    }

    private static List<CommentDto> mapFromComments(List<Comment> comments) {
        return comments.stream()
                .map(CommentMapper::mapToCommentDtos)
                .toList();
    }
}


