package ru.barmatin.homework.dao;

import ru.barmatin.homework.domain.Answer;
import ru.barmatin.homework.domain.Question;
import ru.barmatin.homework.exception.QuestionsLoadingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private final String csvResName;

    public QuestionDaoImpl(String csvResName){
        this.csvResName = csvResName;
    }

    public List<Question> getQuestionList() throws QuestionsLoadingException {
        List<Question> questionList = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(csvResName)) {
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] columns = line.split(",");
                    if (columns.length>1) {
                        List<Answer> answerList = new ArrayList<>();
                        for (int i = 1; i < columns.length; i++) {
                            String text = columns[i].substring(0, columns[i].indexOf("_"));
                            boolean isRight = Boolean.parseBoolean(columns[i].substring(columns[i].indexOf("_")+1));
                            answerList.add(new Answer(text, isRight));
                        }
                        questionList.add(new Question(columns[0], answerList));
                    }
                    else {
                        throw new QuestionsLoadingException("invalid line");
                    }
                }
            } else {
                throw new QuestionsLoadingException("inputStream is null");
            }
        } catch (IOException e) {
            throw new QuestionsLoadingException(e);
        }
        return questionList;
    }
}
