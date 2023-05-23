package com.example.influx.article.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ArticleWithoutCommentsDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime dateAdded;
    private Long category;
    private String userAccount;

}
