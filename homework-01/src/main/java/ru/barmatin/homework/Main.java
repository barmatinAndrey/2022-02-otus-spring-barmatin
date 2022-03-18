package ru.barmatin.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.service.QuestionService;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        List<Question> questionList = questionService.getQuestionList();
        for (Question question: questionList){
            System.out.println(question.getPosition()+". "+question.getQuestionText());
            System.out.println("- "+question.getAnswer1());
            System.out.println("- "+question.getAnswer2());
            System.out.println("- "+question.getAnswer3());
            System.out.println("- "+question.getAnswer4());
            System.out.println("---------------------------------------");
        }
    }
}