package ru.barmatin.homework04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework04.config.TestConfig;
import ru.barmatin.homework04.domain.Answer;
import ru.barmatin.homework04.domain.Question;
import ru.barmatin.homework04.exception.QuestionsLoadingException;

import java.util.List;


@Service
public class TestServiceImpl implements TestService {
    private final QuestionService questionService;
    private final int answersToPass;
    private final IOService ioService;
    private final MessageService messageService;

    @Autowired
    public TestServiceImpl(QuestionService questionService, IOService ioService, TestConfig testConfig, MessageService messageService) {
        this.questionService = questionService;
        this.ioService = ioService;
        this.answersToPass = testConfig.getAnswersToPass();
        this.messageService = messageService;
    }

    public void startTest(String userName) {
        try {
            List<Question> questionList = questionService.getQuestionList();
            int rightAnswersCount = showQuestionList(questionList);
            showTestResult(userName, questionList.size(), rightAnswersCount);
        } catch (QuestionsLoadingException e) {
            ioService.outputString(messageService.getMessage("strings.question.list.failed"));
        }
    }

    private int showQuestionList(List<Question> questionList) {
        int rightAnswersCount = 0;
        for (Question question: questionList) {
            showQuestion(question);
            int answerPosition = enterAnswerPosition(question.getAnswerList().size());
            rightAnswersCount += checkAnswer(question, answerPosition);
            ioService.outputStringLn("------------------------------");
        }
        return rightAnswersCount;
    }

    private void showQuestion(Question question) {
        ioService.outputStringLn("- "+question.getText());
        for (int i=0; i<question.getAnswerList().size(); i++) {
            Answer answer = question.getAnswerList().get(i);
            ioService.outputStringLn((i+1)+". "+answer.getText());
        }
        ioService.outputString(messageService.getMessage("strings.enter.answer.number")+" ");
    }

    private int enterAnswerPosition(int answerListSize) {
        return ioService.readInt(answerListSize, messageService.getMessage("strings.number.out.of.bounds"), messageService.getMessage("strings.not.number"));
    }

    private int checkAnswer(Question question, int answerPosition) {
        if (question.getAnswerList().get(answerPosition-1).isRight()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private void showTestResult(String userName, int questionsCount, int rightAnswersCount) {
        ioService.outputStringLn(userName+messageService.getMessage("strings.result.is")+" "+rightAnswersCount+"/"+questionsCount+".");
        ioService.outputStringLn(rightAnswersCount>=answersToPass ? messageService.getMessage("strings.test.passed") :messageService.getMessage("strings.test.not.passed"));
    }


}
