package ru.barmatin.homework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import ru.barmatin.homework.dao.QuestionDao;
import ru.barmatin.homework.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {
    @Mock
    private QuestionDao questionDao;
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new QuestionServiceImpl(questionDao, "/questions.csv");
    }

    @Test
    void getQuestionListIsNotEmpty() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(1, "Which country's capital is Oslo?", "Uruguay", "Norway", "Kuwait", "Montenegro"));
        given(questionDao.parseQuestionList("/questions.csv")).willReturn(questionList);
        assertThat(questionService.getQuestionList()).isNotEmpty();
    }
}