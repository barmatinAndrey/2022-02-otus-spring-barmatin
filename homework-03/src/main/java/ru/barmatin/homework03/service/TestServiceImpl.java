package ru.barmatin.homework03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.barmatin.homework03.config.YmlTestConfig;
import ru.barmatin.homework03.domain.Answer;
import ru.barmatin.homework03.domain.Question;
import ru.barmatin.homework03.exception.QuestionsLoadingException;

import java.util.List;

import static ru.barmatin.homework03.util.ApplicationUtils.getSourceMsg;

@Service
public class TestServiceImpl implements TestService {
    private final QuestionService questionService;
    private final int answersToPass;
    private final IOService ioService;
    private final MessageSource messageSource;
    private int rightAnswersCount;

    @Autowired
    public TestServiceImpl(QuestionService questionService, IOService ioService, YmlTestConfig ymlTestConfig, MessageSource messageSource) {
        this.questionService = questionService;
        this.ioService = ioService;
        this.answersToPass = ymlTestConfig.getAnswersToPass();
        this.messageSource = messageSource;
    }

    public void startTest() {
        try {
            List<Question> questionList = questionService.getQuestionList();
            rightAnswersCount = 0;
            String userName = enterUserName();
            showQuestionList(questionList);
            showTestResult(userName, questionList.size());
        } catch (QuestionsLoadingException e) {
            ioService.outputString(getSourceMsg(messageSource, "strings.question.list.failed"));
        }
    }

    private String enterUserName() {
        ioService.outputString(getSourceMsg(messageSource, "strings.enter.name")+" ");
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
        ioService.outputString(getSourceMsg(messageSource, "strings.enter.answer.number")+" ");
    }

    private int enterAnswerPosition(int answerListSize) {
        return ioService.readInt(answerListSize);
    }

    private void checkAnswer(Question question, int answerPosition) {
        if (question.getAnswerList().get(answerPosition-1).isRight())
            rightAnswersCount++;
    }

    private void showTestResult(String userName, int questionsCount) {
        ioService.outputStringLn(userName+getSourceMsg(messageSource, "strings.result.is")+" "+rightAnswersCount+"/"+questionsCount+".");
        ioService.outputStringLn(rightAnswersCount>=answersToPass ? getSourceMsg(messageSource, "strings.test.passed") : getSourceMsg(messageSource, "strings.test.not.passed"));
    }


}
