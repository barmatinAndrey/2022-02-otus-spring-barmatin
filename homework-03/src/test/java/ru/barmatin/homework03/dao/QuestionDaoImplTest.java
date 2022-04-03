package ru.barmatin.homework03.dao;

import org.junit.jupiter.api.Test;
import ru.barmatin.homework03.domain.Answer;
import ru.barmatin.homework03.domain.Question;
import ru.barmatin.homework03.exception.QuestionsLoadingException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class QuestionDaoImplTest {

    @Test
    void checkQtyOfAnswers() {
        assertDoesNotThrow(() -> {
            QuestionDao questionDao = new QuestionDaoImpl("/questions_test.csv");
            List<Question> questionList = questionDao.getQuestionList();
            for (Question question: questionList){
                assertEquals(4, question.getAnswerList().size());
            }
        });
    }

    @Test
    void checkRightAnswersQty() {
        assertDoesNotThrow(() -> {
            QuestionDao questionDao = new QuestionDaoImpl("/questions_test.csv");
            List<Question> questionList = questionDao.getQuestionList();
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
            QuestionDao questionDao = new QuestionDaoImpl("/questions_test.csv");
            List<Question> questionList = questionDao.getQuestionList();
            for (Question question: questionList){
                assertThat(question.getText()).contains("?");
            }
        });
    }

    @Test
    void checkException() {
        QuestionDao questionDao = new QuestionDaoImpl("/questions_test_1.csv");
        assertThrows(QuestionsLoadingException.class, questionDao::getQuestionList);
    }
}