package ru.barmatin.homework.dao;

import ru.barmatin.homework.domain.Question;
import java.util.List;

public interface QuestionDao {
    List<Question> parseQuestionList(String csvResName);
}
