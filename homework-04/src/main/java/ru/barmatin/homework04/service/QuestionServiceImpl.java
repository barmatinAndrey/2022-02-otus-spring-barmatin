package ru.barmatin.homework04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework04.dao.QuestionDao;
import ru.barmatin.homework04.domain.Question;
import ru.barmatin.homework04.exception.QuestionsLoadingException;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getQuestionList() throws QuestionsLoadingException {
        return questionDao.getQuestionList();

    }
}
