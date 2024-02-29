package io.quizzz.quizservice.controllers;

import io.quizzz.quizservice.dtos.requestdtos.QuizRequestDto;
import io.quizzz.quizservice.dtos.responsedtos.QuizResponseDto;
import io.quizzz.quizservice.entities.Quiz;
import io.quizzz.quizservice.enums.Category;
import io.quizzz.quizservice.mappers.QuizMapper;
import io.quizzz.quizservice.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizMapper quizMapper;

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<QuizResponseDto> createQuiz(@RequestBody QuizRequestDto quizRequestDto) {

        Quiz newQuiz = quizMapper.toQuiz(quizRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quizService.createQuiz(newQuiz));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.getAllQuizzes());

    }

    //TODO: must take in a query parameter
    @GetMapping("/category")
    public ResponseEntity<List<Quiz>> getQuizByCategory(Category category) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.getQuizByCategory(category));
    }

    @PutMapping("/update")
    public ResponseEntity<QuizResponseDto> updateQuiz(QuizRequestDto quizRequestDto) {
        Quiz quiz = quizMapper.toQuiz(quizRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.updateQuiz(quiz));
    }


    //TODO: check if anything must be passed to the delete mapping
    @DeleteMapping
    public ResponseEntity<String> deleteQuiz(UUID quizId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(quizService.deleteQuiz(quizId));
    }
}
