package ru.barmatin.homework04.test.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import ru.barmatin.homework04.config.TestConfig;
import ru.barmatin.homework04.dao.QuestionDao;
import ru.barmatin.homework04.domain.Answer;
import ru.barmatin.homework04.domain.Question;
import ru.barmatin.homework04.exception.QuestionsLoadingException;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuestionDaoImplTest {

    @Autowired
    private Map<String, QuestionDao> questionDaoMap;

    @Test
    void checkQtyOfAnswers() {
        assertDoesNotThrow(() -> {
            List<Question> questionList = questionDaoMap.get("questionDao").getQuestionList();
            for (Question question: questionList){
                assertEquals(4, question.getAnswerList().size());
            }
        });
    }

    @Test
    void checkRightAnswersQty() {
        assertDoesNotThrow(() -> {
            List<Question> questionList =  questionDaoMap.get("questionDao").getQuestionList();
            for (Question question: questionList){
                int qty = 0;
                for (Answer answer: question.getAnswerList()){
                    if (answer.isRight())
                        qty++;
                }
                assertEquals(1, qty);
            }
        });
    }

    @Test
    void checkQuestionText() {
        assertDoesNotThrow(() -> {
            List<Question> questionList =  questionDaoMap.get("questionDao").getQuestionList();
            for (Question question: questionList){
                assertThat(question.getText()).contains("?");
            }
        });
    }

    @Test
    void checkException() {
        QuestionDao questionDao = questionDaoMap.get("questionDao2");
        assertThrows(QuestionsLoadingException.class, questionDao::getQuestionList);
    }
}