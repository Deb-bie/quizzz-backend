package io.quizzz.quizservice.dtos.requestdtos;

import io.quizzz.quizservice.entities.Question;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@RequiredArgsConstructor
public class AnswerRequestDto {
    private String answer;
    private boolean is_correct_answer;
    private Question question;
}
