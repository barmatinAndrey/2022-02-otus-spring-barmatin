package ru.barmatin.homework.service;

import org.springframework.stereotype.Service;
import ru.barmatin.homework.util.MyUtils;

import java.util.Scanner;

@Service
public class ConsoleServiceImpl implements ConsoleService {
    private final Scanner scanner;

    public ConsoleServiceImpl() {
        this.scanner = new Scanner(System.in);
    }

    public void consoleOut(String text) {
        System.out.print(text);
    }

    public void consoleOutLn(String text) {
        System.out.println(text);
    }

    @Override
    public String consoleInString() {
        return scanner.nextLine();
    }

    @Override
    public int consoleInInt(int maxNumber) {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (MyUtils.isInteger(input)){
                int inputNumber = Integer.parseInt(input);
                if (inputNumber>0 && inputNumber<=maxNumber)
                    break;
                else
                    System.out.print("Number out of bounds, please, try again: ");
            }
            else
                System.out.print("Not number entered, please, try again: ");
        }
        return Integer.parseInt(input);
    }

}
