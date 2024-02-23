package io.quizzz.quizservice.dtos.requestdtos;

import io.quizzz.quizservice.enums.Category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@RequiredArgsConstructor
public class CreateQuizRequestDto {
    private String quiz_name;
    private int number_of_questions;
    private Category category;
    private LocalDate start_date;
    private LocalTime start_time;
}
