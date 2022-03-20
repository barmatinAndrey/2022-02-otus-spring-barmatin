package ru.barmatin.homework.dao;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.barmatin.homework.domain.Answer;
import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionDaoImplTest {
    private List<Question> questionList;

    @BeforeEach
    void setUp() {
        QuestionDao questionDao = new QuestionDaoImpl("/questions_test.csv");
        questionList = null;
        try {
            questionList = questionDao.getQuestionList();
        } catch (QuestionsLoadingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkQtyOfAnswers() {
        for (Question question: questionList){
            assertEquals(4, question.getAnswerList().size());
        }
    }

    @Test
    void checkRightAnswersQty() {
        for (Question question: questionList){
            int qty = 0;
            for (Answer answer: question.getAnswerList()){
                if (answer.isRight())
                    qty++;
            }
            assertEquals(1, qty);
        }
    }

    @Test
    void checkQuestionText() {
        for (Question question: questionList){
            assertThat(question.getText()).contains("?");
        }
    }




}