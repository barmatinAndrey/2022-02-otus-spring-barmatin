package ru.barmatin.homework05.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {
    private final Scanner scanner;

    public IOServiceImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void outputString(String text) {
        System.out.print(text);
    }

    @Override
    public void outputStringLn(String text) {
        System.out.println(text);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }
}
