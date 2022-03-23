package ru.barmatin.homework.service;

import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestionList() throws QuestionsLoadingException;
}
