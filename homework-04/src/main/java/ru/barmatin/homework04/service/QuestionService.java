package ru.barmatin.homework04.service;

import ru.barmatin.homework04.domain.Question;
import ru.barmatin.homework04.exception.QuestionsLoadingException;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestionList() throws QuestionsLoadingException;
}
