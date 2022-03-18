package ru.barmatin.homework.dao;

import ru.barmatin.homework.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoCSV implements QuestionDao {

    public List<Question> parseQuestionList(String csvResName) {
        List<Question> questionList = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getResourceAsStream(csvResName);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] columns = line.split(",");
                    questionList.add(new Question(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return questionList;
    }
}
