package ru.barmatin.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework.dao.QuestionDao;
import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;
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
