package ru.barmatin.homework03.service;

public interface InputService {

    String readString();

    int readInt(int maxNumber, String outOfBounds, String notNumber);
}
