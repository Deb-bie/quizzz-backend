package io.quizzz.quizservice.mappers;


import io.quizzz.quizservice.dtos.requestdtos.CreateQuizRequestDto;
import io.quizzz.quizservice.dtos.responsedtos.CreateQuizResponseDto;
import io.quizzz.quizservice.entities.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper {

    Quiz toQuiz(CreateQuizRequestDto createQuizRequestDto);

    CreateQuizResponseDto toCreateQuizResponseDto(Quiz quiz);

}
