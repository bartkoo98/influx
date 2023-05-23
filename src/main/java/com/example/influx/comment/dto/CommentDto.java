package com.example.influx.comment.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class CommentDto {
    private Long id;
    private String content;
    private LocalDateTime dateAdded;
    private String userAccount;
    private long article;
}
