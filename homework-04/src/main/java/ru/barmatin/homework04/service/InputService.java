package ru.barmatin.homework04.service;

public interface InputService {

    String readString();

    int readInt(int maxNumber, String outOfBoundsError, String notNumberError);
}
