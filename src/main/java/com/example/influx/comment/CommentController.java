package com.example.influx.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

}
