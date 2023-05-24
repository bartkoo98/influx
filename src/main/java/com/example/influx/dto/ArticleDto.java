package com.example.influx.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime dateAdded;
    private Long category;
    private String userAccount;
    private List<CommentDto> comments;
}
