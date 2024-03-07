package io.quizzz.quizservice.dtos.responsedtos;

import io.quizzz.quizservice.entities.Question;
import io.quizzz.quizservice.enums.Category;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


@Setter
@Getter
@RequiredArgsConstructor
public class QuizResponseDto {
    private UUID quiz_id;
    private String quiz_name;
    private int number_of_questions;
    private Category category;
    private LocalDate start_date;
    private LocalTime start_time;
    private List<Question> questions;
    private Timestamp created_at;
    private Timestamp updated_at;
}
