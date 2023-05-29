package com.example.influx.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class CommentDto {
    private Long id;
    @NotEmpty
    @Size(min = 1, message = "Comment should have minimum 1 character")
    private String content;
    @NotEmpty(message = "Name should not be null or empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")

    private LocalDateTime dateAdded;
    private String userAccount;
    @JsonIgnore
    private long article;
}
