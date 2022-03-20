package ru.barmatin.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.barmatin.homework.dao.QuestionDao;
import ru.barmatin.homework.dao.QuestionDaoImpl;


@Configuration
public class DaoConfig {

    @Bean
    QuestionDao questionDao(@Value("${test.file}") String csvResName) {
        return new QuestionDaoImpl(csvResName);
    }

}
