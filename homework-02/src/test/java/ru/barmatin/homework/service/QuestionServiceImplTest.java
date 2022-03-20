package ru.barmatin.homework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import ru.barmatin.homework.dao.QuestionDao;
import ru.barmatin.homework.domain.Answer;
import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;
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
        questionService = new QuestionServiceImpl(questionDao);
    }

    @Test
    void getQuestionList() throws QuestionsLoadingException {
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Uruguay", false));
        answerList.add(new Answer("Norway", true));
        questionList.add(new Question("Which country's capital is Oslo?", answerList));
        given(questionDao.getQuestionList()).willReturn(questionList);
        assertThat(questionService.getQuestionList().get(0).getText()).isEqualTo("Which country's capital is Oslo?");
        assertThat(questionService.getQuestionList().get(0).getAnswerList().get(0).getText()).isEqualTo("Uruguay");
        assertThat(questionService.getQuestionList().get(0).getAnswerList().get(1).getText()).isEqualTo("Norway");
    }
}