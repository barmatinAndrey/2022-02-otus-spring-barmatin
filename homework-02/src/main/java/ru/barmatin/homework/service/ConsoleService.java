package ru.barmatin.homework.service;

public interface ConsoleService {

    void consoleOut(String text);

    void consoleOutLn(String text);

    String consoleInString();

    int consoleInInt(int maxNumber);
}
