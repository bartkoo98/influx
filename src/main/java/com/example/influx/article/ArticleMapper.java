package com.example.influx.article;

import com.example.influx.article.dto.ArticleDto;
import com.example.influx.article.dto.ArticleWithoutCommentsDto;
import com.example.influx.comment.Comment;
import com.example.influx.comment.CommentMapper;
import com.example.influx.comment.dto.CommentDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArticleMapper {

    public static List<ArticleWithoutCommentsDto> mapToArticleWithoutCommentsDtos(List<Article> articles) {
        return  articles.stream()
                .map(ArticleMapper::mapToArticleWithoutCommentsDto)
                .collect(Collectors.toList());
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

    public static ArticleDto mapToArticleDtos(Article article) {
        return mapToArticleDto(article);
    }

    private static ArticleDto mapToArticleDto(Article article) {
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


