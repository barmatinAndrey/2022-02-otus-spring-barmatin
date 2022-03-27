package ru.barmatin.homework.service;

import org.springframework.stereotype.Service;
import ru.barmatin.homework.util.ApplicationUtils;

import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {
    private final Scanner scanner;

    public IOServiceImpl() {
        this.scanner = new Scanner(System.in);
    }

    public void outputString(String text) {
        System.out.print(text);
    }

    public void outputStringLn(String text) {
        System.out.println(text);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public int readInt(int maxNumber) {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (ApplicationUtils.isInteger(input)) {
                int inputNumber = Integer.parseInt(input);
                if (inputNumber>0 && inputNumber<=maxNumber) {
                    break;
                }
                else {
                    System.out.print("Number out of bounds, please, try again: ");
                }
            }
            else {
                System.out.print("Not number entered, please, try again: ");
            }
        }
        return Integer.parseInt(input);
    }

}
