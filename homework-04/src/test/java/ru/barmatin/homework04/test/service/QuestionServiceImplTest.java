package ru.barmatin.homework04.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.barmatin.homework04.exception.QuestionsLoadingException;
import ru.barmatin.homework04.service.QuestionService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuestionServiceImplTest {
    @Autowired
    private QuestionService questionService;

    @Test
    void getQuestionList() throws QuestionsLoadingException {
        assertThat(questionService.getQuestionList().get(0).getText()).isEqualTo("Which country's capital is Oslo?");
        assertThat(questionService.getQuestionList().get(0).getAnswerList().get(0).getText()).isEqualTo("Uruguay");
        assertThat(questionService.getQuestionList().get(0).getAnswerList().get(1).getText()).isEqualTo("Norway");
        assertThat(questionService.getQuestionList().get(0).getAnswerList().get(2).getText()).isEqualTo("Kuwait");
        assertThat(questionService.getQuestionList().get(0).getAnswerList().get(3).getText()).isEqualTo("Montenegro");
        assertThat(questionService.getQuestionList().get(1).getText()).isEqualTo("Which country's capital is Havana?");
        assertThat(questionService.getQuestionList().get(1).getAnswerList().get(0).getText()).isEqualTo("Bolivia");
        assertThat(questionService.getQuestionList().get(1).getAnswerList().get(1).getText()).isEqualTo("New Zealand");
        assertThat(questionService.getQuestionList().get(1).getAnswerList().get(2).getText()).isEqualTo("Cuba");
        assertThat(questionService.getQuestionList().get(1).getAnswerList().get(3).getText()).isEqualTo("Rwanda");
    }
}