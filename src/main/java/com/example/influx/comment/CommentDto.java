package com.example.influx.comment;

import com.example.influx.user.UserAccount;

import java.time.LocalDateTime;

public class CommentDto {
    private Long id;
    private String content;
    private LocalDateTime dateAdded;
    private UserAccount userAccount;
}
