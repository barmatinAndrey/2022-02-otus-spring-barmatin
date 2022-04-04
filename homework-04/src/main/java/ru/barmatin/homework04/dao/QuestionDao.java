package ru.barmatin.homework04.dao;

import ru.barmatin.homework04.domain.Question;
import ru.barmatin.homework04.exception.QuestionsLoadingException;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionList() throws QuestionsLoadingException;
}
