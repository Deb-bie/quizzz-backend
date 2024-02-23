package io.quizzz.quizservice.entities;

import io.quizzz.quizservice.enums.Difficulty;
import io.quizzz.quizservice.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "question")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private UUID question_id;

    @Column(nullable = false)
    private  String question;

    @Column(nullable = false)
    private QuestionType questionType;

    @Column(nullable = false)
    private int time_limit;

    @Column(nullable = false)
    private boolean default_time;

    @Column(nullable = false)
    private Difficulty difficulty;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @Column(nullable = false)
    private Timestamp created_at;

    @Column(nullable = false)
    private Timestamp updated_at;
}