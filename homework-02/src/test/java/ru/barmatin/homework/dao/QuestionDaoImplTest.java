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

class QuestionDaoImplTest {

    @Test
    void checkQtyOfAnswers() {
        QuestionDao questionDao = new QuestionDaoImpl("/questions_test.csv");
        try {
            List<Question> questionList = questionDao.getQuestionList();
            for (Question question: questionList){
                assertEquals(4, question.getAnswerList().size());
            }
        } catch (QuestionsLoadingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkRightAnswersQty() {
        QuestionDao questionDao = new QuestionDaoImpl("/questions_test.csv");
        try {
            List<Question> questionList = questionDao.getQuestionList();
            for (Question question: questionList){
                int qty = 0;
                for (Answer answer: question.getAnswerList()){
                    if (answer.isRight())
                        qty++;
                }
                assertEquals(1, qty);
            }
        } catch (QuestionsLoadingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkQuestionText() {
        QuestionDao questionDao = new QuestionDaoImpl("/questions_test.csv");
        try {
            List<Question> questionList = questionDao.getQuestionList();
            for (Question question: questionList){
                assertThat(question.getText()).contains("?");
            }
        } catch (QuestionsLoadingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkException() {
        QuestionDao questionDao = new QuestionDaoImpl("/questions_test_1.csv");
        assertThrows(QuestionsLoadingException.class, questionDao::getQuestionList);
    }
}