package io.quizzz.quizservice.services;


import io.quizzz.quizservice.dtos.responsedtos.CreateQuizResponseDto;
import io.quizzz.quizservice.entities.Quiz;
import io.quizzz.quizservice.mappers.QuizMapper;
import io.quizzz.quizservice.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizMapper quizMapper;

    public CreateQuizResponseDto createQuiz(Quiz quiz){
        quiz.setCreated_at(Timestamp.valueOf(LocalDateTime.now()));
        quiz.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
        Quiz createdQuiz = quizRepository.save(quiz);


        // logging to reports db

        return quizMapper.toCreateQuizResponseDto(createdQuiz);
    }
}
