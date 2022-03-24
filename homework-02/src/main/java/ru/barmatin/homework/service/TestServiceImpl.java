package ru.barmatin.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.barmatin.homework.domain.Answer;
import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final QuestionService questionService;
    private final int answersToPass;
    private final IOService ioService;
    private int rightAnswersCount;

    @Autowired
    public TestServiceImpl(QuestionService questionService, IOService ioService, @Value("${answers.to.pass}") int answersToPass) {
        this.questionService = questionService;
        this.ioService = ioService;
        this.answersToPass = answersToPass;
    }

    public void startTest() {
        try {
            List<Question> questionList = questionService.getQuestionList();
            rightAnswersCount = 0;
            String userName = enterUserName();
            showQuestionList(questionList);
            showTestResult(userName, questionList.size());
        } catch (QuestionsLoadingException e) {
            ioService.outputString("Test can't be started, because receiving list of questions failed.");
        }
    }

    private String enterUserName() {
        ioService.outputString("Enter your full name: ");
        return ioService.readString();
    }

    private void showQuestionList(List<Question> questionList) {
        for (Question question: questionList) {
            showQuestion(question);
            int answerPosition = enterAnswerPosition(question.getAnswerList().size());
            checkAnswer(question, answerPosition);
            ioService.outputStringLn("------------------------------");
        }
    }

    private void showQuestion(Question question) {
        ioService.outputStringLn("- "+question.getText());
        for (int i=0; i<question.getAnswerList().size(); i++) {
            Answer answer = question.getAnswerList().get(i);
            ioService.outputStringLn((i+1)+". "+answer.getText());
        }
        ioService.outputString("Enter number of your answer: ");
    }

    private int enterAnswerPosition(int answerListSize) {
        return ioService.readInt(answerListSize);
    }

    private void checkAnswer(Question question, int answerPosition) {
        if (question.getAnswerList().get(answerPosition-1).isRight())
            rightAnswersCount++;
    }

    private void showTestResult(String userName, int questionsCount) {
        ioService.outputStringLn(userName+", your result is "+rightAnswersCount+"/"+questionsCount+".");
        ioService.outputStringLn(rightAnswersCount>=answersToPass ? "Congratulations, test passed!" : "Test is not passed:(");
    }


}
