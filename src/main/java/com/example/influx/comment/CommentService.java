package com.example.influx.comment;

import com.example.influx.article.Article;
import com.example.influx.user.UserService;
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
