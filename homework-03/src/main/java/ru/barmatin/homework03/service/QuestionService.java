package ru.barmatin.homework03.service;

import ru.barmatin.homework03.domain.Question;
import ru.barmatin.homework03.exception.QuestionsLoadingException;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestionList() throws QuestionsLoadingException;
}
