package com.example.influx.mapper;

import com.example.influx.entity.Comment;
import com.example.influx.dto.CommentDto;

public class CommentMapper {
    public static CommentDto mapToCommentDtos(Comment comment) {
        return mapToCommentDto(comment);
    }

    private static CommentDto mapToCommentDto(Comment comment) {
        var userAccount = comment.getUserAccount();
        var article = comment.getArticle();
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .dateAdded(comment.getDateAdded())
                .userAccount(userAccount.getEmail())
                .article(article.getId())
                .build();
    }
}
