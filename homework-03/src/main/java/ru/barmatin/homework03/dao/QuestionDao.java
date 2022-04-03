package ru.barmatin.homework03.dao;

import ru.barmatin.homework03.domain.Question;
import ru.barmatin.homework03.exception.QuestionsLoadingException;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionList() throws QuestionsLoadingException;
}
