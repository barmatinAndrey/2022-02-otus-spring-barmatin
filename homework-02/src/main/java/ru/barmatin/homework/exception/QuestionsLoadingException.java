package ru.barmatin.homework.exception;

public class QuestionsLoadingException extends Exception {

    public QuestionsLoadingException(String message){
        super(message);
    }

    public QuestionsLoadingException(Throwable cause){
        super(cause);
    }

}
