package io.quizzz.quizservice.dtos.requestdtos;

import io.quizzz.quizservice.entities.Quiz;
import io.quizzz.quizservice.enums.Difficulty;
import io.quizzz.quizservice.enums.QuestionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class QuestionRequestDto {
    private  String question;
    private QuestionType questionType;
    private int time_limit;
    private boolean default_time;
    private Difficulty difficulty;
    private Quiz quiz;


}
