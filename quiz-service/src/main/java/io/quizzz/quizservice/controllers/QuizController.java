package io.quizzz.quizservice.controllers;

import io.quizzz.quizservice.dtos.requestdtos.CreateQuizRequestDto;
import io.quizzz.quizservice.dtos.responsedtos.CreateQuizResponseDto;
import io.quizzz.quizservice.entities.Quiz;
import io.quizzz.quizservice.mappers.QuizMapper;
import io.quizzz.quizservice.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizMapper quizMapper;

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<CreateQuizResponseDto> createQuiz(@RequestBody CreateQuizRequestDto createQuizRequestDto){

        Quiz newQuiz = quizMapper.toQuiz(createQuizRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quizService.createQuiz(newQuiz));
    }
}
