package io.quizzz.quizservice.mappers;

import io.quizzz.quizservice.dtos.requestdtos.AnswerRequestDto;
import io.quizzz.quizservice.dtos.responsedtos.AnswerResponseDto;
import io.quizzz.quizservice.entities.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer toAnswer(AnswerRequestDto answerRequestDto);
    AnswerResponseDto toAnswerResponseDto(Answer answer);
}
