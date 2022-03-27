package ru.barmatin.homework03.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.barmatin.homework03.dao.QuestionDao;
import ru.barmatin.homework03.dao.QuestionDaoImpl;

import static ru.barmatin.homework03.util.ApplicationUtils.LOCALE_TAG;


@Configuration
public class DaoConfig {

    @Bean
    QuestionDao questionDao(YmlTestConfig ymlTestConfig) {
        String filePath = LOCALE_TAG.isEmpty() ? ymlTestConfig.getFile()+"."+ymlTestConfig.getExtension() :
                ymlTestConfig.getFile()+"_"+LOCALE_TAG+"."+ymlTestConfig.getExtension();
        return new QuestionDaoImpl(filePath);
    }

}
