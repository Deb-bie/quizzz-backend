package io.quizzz.quizservice.services;


import io.quizzz.quizservice.dtos.requestdtos.AnswerRequestDto;
import io.quizzz.quizservice.dtos.responsedtos.AnswerResponseDto;
import io.quizzz.quizservice.entities.Answer;
import io.quizzz.quizservice.entities.Question;
import io.quizzz.quizservice.mappers.AnswerMapper;
import io.quizzz.quizservice.repositories.AnswerRepository;
import io.quizzz.quizservice.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerMapper answerMapper;


    // when creating an answer, based off on the question type, the answer will be limited
    // mul = 1+
    //sing = 2+
    //tru/fal = 2
    public AnswerResponseDto createAnswer(Answer answer){
        //TODO: let me check whether that answer(text) already exists under the question

            answer.setCreated_at(Timestamp.valueOf(LocalDateTime.now()));
            answer.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));

            Answer createdAnswer = answerRepository.save(answer);

            // TODO: log to reports
            return answerMapper.toAnswerResponseDto(createdAnswer);
    }

    public AnswerResponseDto getAnswer(UUID answerID){
        Optional<Answer> optionalAnswer = answerRepository.findById(answerID);
        if (optionalAnswer.isPresent()){
            return answerMapper.toAnswerResponseDto(optionalAnswer.get());
        }
        // TODO: throw an exception, answer is not available/found
        return null;
    }

    public List<AnswerResponseDto> getAllAnswersUnderAQuestion(UUID questionID){
        List<AnswerResponseDto> answerResponseDto = new ArrayList<>();
        Optional<Question> question = questionRepository.findById(questionID);
        if (question.isPresent()){
            List<Answer> allAnswersUnderAQuestion = question.get().getAnswers();

            for (Answer answer : allAnswersUnderAQuestion) {
                answerResponseDto.add(answerMapper.toAnswerResponseDto(answer));
            }
            return answerResponseDto;
        } else{
            //TODO: throw an exception. question was not found
        }
        return null;
    }


    public boolean isCorrectAnswer(UUID answerID){
        Optional<Answer> answer = answerRepository.findById(answerID);
        if (answer.isPresent()){
            return answer.get().is_correct_answer();
        } else {
            //TODO:  throw an exception, answer is not found
        }
        return false;
    }

    public String deleteAnswer(UUID answerID){
        Optional<Answer> answer = answerRepository.findById(answerID);
        if (answer.isPresent()){
            answerRepository.deleteById(answerID);
            //TODO: log to reports
            return "Answer Deleted";
        } else {
            //TODO:  throw an exception, answer is not found
        }
        return null;
    }

}
