package io.quizzz.quizservice.services;

import io.quizzz.quizservice.dtos.responsedtos.QuestionResponseDto;
import io.quizzz.quizservice.entities.Question;
import io.quizzz.quizservice.mappers.QuestionMapper;
import io.quizzz.quizservice.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class QuestionService {
    @Autowired
    public QuestionRepository questionRepository;

    @Autowired
    public QuestionMapper questionMapper;

    public QuestionResponseDto createQuestion (Question question){
        Question createdQuestion = questionRepository.save(question);

        //TODO: log into the reports and db

        return questionMapper.toCreateQuestionResponseDto(createdQuestion);
    }


    public QuestionResponseDto updateQuestion(Question question){
        question.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
        Question updatedQuestion = questionRepository.save(question);

        //TODO: log updates

        return questionMapper.toCreateQuestionResponseDto(updatedQuestion);


    }


}
