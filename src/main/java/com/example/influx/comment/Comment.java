package com.example.influx.comment;

import com.example.influx.user.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime dateAdded;
    @OneToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
}
