package com.example.ndtest.Question;

import com.example.ndtest.Answer.Answer;
import com.example.ndtest.User.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import jakarta.persistence.ManyToMany;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
