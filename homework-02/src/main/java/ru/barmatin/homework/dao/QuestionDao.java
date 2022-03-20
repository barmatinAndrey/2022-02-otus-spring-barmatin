package ru.barmatin.homework.dao;

import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionList() throws QuestionsLoadingException;
}
