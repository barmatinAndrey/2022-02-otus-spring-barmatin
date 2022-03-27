package ru.barmatin.homework.domain;

public class Answer {
    private final String text;
    private final boolean isRight;

    public Answer(String text, boolean isRight) {
        this.text = text;
        this.isRight = isRight;
    }

    public String getText() {
        return text;
    }

    public boolean isRight() {
        return isRight;
    }
}
