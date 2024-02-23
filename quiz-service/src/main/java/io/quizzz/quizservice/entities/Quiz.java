package io.quizzz.quizservice.entities;


import io.quizzz.quizservice.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "quiz")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quiz {
    @Id
    @GeneratedValue
    private UUID quiz_id;

    @Column(nullable = false)
    private String quiz_name;

    @Column(nullable = false)
    private int number_of_questions;

    @Column(nullable = false)
    private Category category;

//    author

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalTime start_time;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "quiz")
    private List<Question> questions;

    @Column(nullable = false)
    private Timestamp created_at;

    @Column(nullable = false)
    private Timestamp updated_at;
}
