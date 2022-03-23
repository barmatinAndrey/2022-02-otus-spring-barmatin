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
    private final IOService IOService;
    private int rightAnswersCount;

    @Autowired
    public TestServiceImpl(QuestionService questionService, IOService IOService, @Value("${answers.to.pass}") int answersToPass) {
        this.questionService = questionService;
        this.IOService = IOService;
        this.answersToPass = answersToPass;
    }

    public void startTest() {
        try {
            List<Question> questionList = questionService.getQuestionList();
            rightAnswersCount = 0;
            String userName = printUserName();
            for (Question question: questionList) {
                showQuestion(question);
                int answerPosition = printAnswerPosition(question.getAnswerList().size());
                checkAnswer(question, answerPosition);
                IOService.outputStringLn("------------------------------");
            }
            showTestResult(userName, questionList.size());
        } catch (QuestionsLoadingException e) {
            IOService.outputString("Test can't be started, because receiving list of questions failed.");
            System.exit(0);
        }
    }

    private String printUserName() {
        IOService.outputString("Enter your full name: ");
        return IOService.readString();
    }

    private void showQuestion(Question question) {
        IOService.outputStringLn("- "+question.getText());
        for (int i=0; i<question.getAnswerList().size(); i++) {
            Answer answer = question.getAnswerList().get(i);
            IOService.outputStringLn((i+1)+". "+answer.getText());
        }
        IOService.outputString("Enter number of your answer: ");
    }

    private int printAnswerPosition(int answerListSize) {
        return IOService.readInt(answerListSize);
    }

    private void checkAnswer(Question question, int answerPosition) {
        if (question.getAnswerList().get(answerPosition-1).isRight())
            rightAnswersCount++;
    }

    private void showTestResult(String userName, int questionsCount) {
        IOService.outputStringLn(userName+", your result is "+rightAnswersCount+"/"+questionsCount+".");
        IOService.outputStringLn(rightAnswersCount>=answersToPass ? "Congratulations, test passed!" : "Test is not passed:(");
    }


}
