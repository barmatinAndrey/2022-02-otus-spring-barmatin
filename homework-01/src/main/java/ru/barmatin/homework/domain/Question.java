package ru.barmatin.homework.domain;

public class Question {
    private final int position;
    private final String questionText;
    private final String answer1;
    private final String answer2;
    private final String answer3;
    private final String answer4;

    public Question(int position, String questionText, String answer1, String answer2, String answer3, String answer4) {
        this.position = position;
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public int getPosition() {
        return position;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

}
