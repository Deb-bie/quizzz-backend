package io.quizzz.quizservice.dtos.responsedtos;


import io.quizzz.quizservice.entities.Answer;
import io.quizzz.quizservice.entities.Quiz;
import io.quizzz.quizservice.enums.Difficulty;
import io.quizzz.quizservice.enums.QuestionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@RequiredArgsConstructor
public class QuestionResponseDto {
    private UUID question_id;
    private  String question;
    private QuestionType questionType;
    private int time_limit;
    private boolean default_time;
    private Difficulty difficulty;
    private Quiz quiz;
    private List<Answer> answers;
    private Timestamp created_at;
    private Timestamp updated_at;
}
