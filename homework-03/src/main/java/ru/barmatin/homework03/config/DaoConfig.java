package ru.barmatin.homework03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.barmatin.homework03.dao.QuestionDao;
import ru.barmatin.homework03.dao.QuestionDaoImpl;


@Configuration
public class DaoConfig {

    @Bean
    QuestionDao questionDao(TestConfig testConfig) {
        String filePath = testConfig.getLocale().equals("default") ? testConfig.getFile()+"."+ testConfig.getExtension() :
                testConfig.getFile()+"_"+ testConfig.getLocale()+"."+ testConfig.getExtension();
        return new QuestionDaoImpl(filePath);
    }

}
