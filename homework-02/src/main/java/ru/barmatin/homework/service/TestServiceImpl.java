package ru.barmatin.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.barmatin.homework.domain.Answer;
import ru.barmatin.homework.domain.Question;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final QuestionService questionService;
    private final int answersToPass;
    private final ConsoleService consoleService;

    @Autowired
    public TestServiceImpl(QuestionService questionService, ConsoleService consoleService, @Value("${answers.to.pass}") int answersToPass) {
        this.questionService = questionService;
        this.consoleService = consoleService;
        this.answersToPass = answersToPass;
    }

    public void startTest() {
        if (questionService.getQuestionList() != null) {
            consoleService.consoleOut("Enter your full name: ");
            String userName = consoleService.consoleInString();
            int rightAnswersCount = 0;
            List<Question> questionList = questionService.getQuestionList();
            for (Question question: questionList) {
                consoleService.consoleOutLn("- "+question.getText());
                for (int i=0; i<question.getAnswerList().size(); i++) {
                    Answer answer = question.getAnswerList().get(i);
                    consoleService.consoleOutLn((i+1)+". "+answer.getText());
                }
                consoleService.consoleOut("Enter number of your answer: ");
                int answerPosition = consoleService.consoleInInt(question.getAnswerList().size());
                if (question.getAnswerList().get(answerPosition-1).isRight())
                    rightAnswersCount++;
                consoleService.consoleOutLn("------------------------------");
            }
            consoleService.consoleOutLn(userName+", your result is "+rightAnswersCount+"/"+questionList.size()+".");
            consoleService.consoleOutLn(rightAnswersCount>=answersToPass ? "Congratulations, test passed!" : "Test is not passed:(");
        }
        else
            consoleService.consoleOut("Test can't be started, because receiving list of questions failed");
    }
}
