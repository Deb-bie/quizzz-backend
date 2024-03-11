package io.quizzz.quizservice.dtos.responsedtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quizzz.quizservice.entities.Question;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;


@Setter
@Getter
@RequiredArgsConstructor
public class AnswerResponseDto {
    @JsonIgnore
    private Question question;
    private UUID answer_id;
    private String answer;
    private boolean is_correct_answer;
    private Timestamp created_at;
    private Timestamp updated_at;
}
