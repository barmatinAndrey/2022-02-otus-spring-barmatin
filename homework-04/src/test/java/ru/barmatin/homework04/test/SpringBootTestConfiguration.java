package ru.barmatin.homework04.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import ru.barmatin.homework04.config.TestConfig;
import ru.barmatin.homework04.dao.QuestionDao;
import ru.barmatin.homework04.dao.QuestionDaoImpl;
import ru.barmatin.homework04.service.QuestionService;
import ru.barmatin.homework04.service.QuestionServiceImpl;

@SpringBootConfiguration
public class SpringBootTestConfiguration {

    @Bean
    TestConfig testConfig(@Value("${test.file}") String file, @Value("${test.extension}") String extension){
        TestConfig testConfig = new TestConfig();
        testConfig.setFile(file);
        testConfig.setExtension(extension);
        return testConfig;
    }

    @Bean
    QuestionDao questionDao(TestConfig testConfig) {
        return new QuestionDaoImpl(testConfig.getFile()+"."+testConfig.getExtension());
    }

    @Bean
    QuestionDao questionDao2() {
        return new QuestionDaoImpl("/questions_test_1.csv");
    }

    @Bean
    QuestionService questionService(QuestionDao questionDao) {
        return new QuestionServiceImpl(questionDao);
    }

}
