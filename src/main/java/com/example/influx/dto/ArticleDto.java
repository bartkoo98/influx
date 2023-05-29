package com.example.influx.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
public class ArticleDto {
    private Long id;
    @NotEmpty
    @Size(min = 5, message = "Article title should have minimum 5 characters.")
    private String title;
    @NotEmpty
    @Size(min = 50, message = "Article content should have minimum 50 characters.")
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAdded;
    private Long category;
    private String userAccount;
    private List<CommentDto> comments;
}
