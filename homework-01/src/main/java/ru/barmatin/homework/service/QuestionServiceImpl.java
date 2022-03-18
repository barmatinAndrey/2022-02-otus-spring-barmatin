package ru.barmatin.homework.service;

import ru.barmatin.homework.dao.QuestionDao;
import ru.barmatin.homework.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final String csvResName;

    public QuestionServiceImpl(QuestionDao questionDao, String csvResName) {
        this.questionDao = questionDao;
        this.csvResName = csvResName;
    }

    public List<Question> getQuestionList() {
        return questionDao.parseQuestionList(csvResName);
    }
}
