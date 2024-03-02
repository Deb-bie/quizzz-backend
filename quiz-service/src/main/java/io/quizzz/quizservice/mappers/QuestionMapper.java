package io.quizzz.quizservice.mappers;

import io.quizzz.quizservice.dtos.responsedtos.QuestionResponseDto;
import io.quizzz.quizservice.entities.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionResponseDto toCreateQuestionResponseDto(Question question);
}
