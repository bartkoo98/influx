package com.example.influx.article;

import com.example.influx.category.Category;
import com.example.influx.comment.Comment;
import com.example.influx.user.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime dateAdded;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @OneToMany(cascade = CascadeType.REMOVE) // potrzebne do usuniecia komentarzy przy usuwaniu posta
    @JoinColumn(name="article_id", updatable = false, insertable = false)
    private List<Comment> comment;
}
