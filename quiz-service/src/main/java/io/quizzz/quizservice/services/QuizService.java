package io.quizzz.quizservice.services;


import io.quizzz.quizservice.dtos.responsedtos.QuestionResponseDto;
import io.quizzz.quizservice.dtos.responsedtos.QuizResponseDto;
import io.quizzz.quizservice.entities.Question;
import io.quizzz.quizservice.entities.Quiz;
import io.quizzz.quizservice.enums.Category;
import io.quizzz.quizservice.mappers.QuestionMapper;
import io.quizzz.quizservice.mappers.QuizMapper;
import io.quizzz.quizservice.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizMapper quizMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public QuizResponseDto createQuiz(Quiz quiz){
        quiz.setCreated_at(Timestamp.valueOf(LocalDateTime.now()));
        quiz.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
        Quiz createdQuiz = quizRepository.save(quiz);
        //TODO: logging to reports db
        return quizMapper.toQuizResponseDto(createdQuiz);
    }

    public List<Quiz> getAllQuizzes(){
        return quizRepository.findAll();
    }

    public List<Quiz> getQuizByCategory(Category category){
        Optional<Quiz> quizzes = quizRepository.findByCategory(category);
        if (quizzes.isPresent()){
            return quizzes.stream().toList();
        }
        //TODO: throw exception
        return null;
    }

    public QuizResponseDto getAQuiz(UUID quizID){
        Optional<Quiz> quiz = quizRepository.findById(quizID);
        if (quiz.isEmpty()){
            //TODO: THROW AN EXCEPTION
        }
        return quizMapper.toQuizResponseDto(quiz.get());
    }


    public List<QuestionResponseDto> getAllQuestionsUnderAQuiz(UUID quizID){
        Optional<Quiz> quiz = quizRepository.findById(quizID);
        List<QuestionResponseDto> questionResponseDtoList = new ArrayList<>();
        if (quiz.isEmpty()){
            //TODO: THROW AN EXCEPTION
        }
        List<Question> questions = quiz.get().getQuestions();
        for(Question question : questions){
            questionResponseDtoList.add(questionMapper.toQuestionResponseDto(question));
        }
        return questionResponseDtoList;
    }


    public QuizResponseDto updateQuiz(Quiz quiz){
        quiz.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
        Quiz updatedQuiz = quizRepository.save(quiz);
        //TODO: logging

        return quizMapper.toQuizResponseDto(updatedQuiz);

    }


    public String deleteQuiz(UUID quizId){
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()){
            quizRepository.deleteById(quizId);
            //TODO: logging


            //TODO: return something to indicate that quiz has been deleted

        }
        else {
            //TODO: throw an exception
        }
        return "Deleted";
    }


}
