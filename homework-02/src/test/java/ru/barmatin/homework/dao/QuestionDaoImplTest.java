package ru.barmatin.homework.dao;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.barmatin.homework.domain.Answer;
import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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