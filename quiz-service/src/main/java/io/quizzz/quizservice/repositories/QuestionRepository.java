package io.quizzz.quizservice.repositories;

import io.quizzz.quizservice.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
}
