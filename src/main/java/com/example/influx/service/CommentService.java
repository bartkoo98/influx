package com.example.influx.service;

import com.example.influx.entity.Comment;
import com.example.influx.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


    public List<Comment> getAllCommentsForArticle(Long articleId) {
        return commentRepository.findByArticleId(articleId);
    }

}
