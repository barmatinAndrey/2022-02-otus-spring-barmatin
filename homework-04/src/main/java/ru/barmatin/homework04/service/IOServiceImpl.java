package ru.barmatin.homework04.service;

import org.springframework.stereotype.Service;
import ru.barmatin.homework04.util.NumericUtils;

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
    public int readInt(int maxNumber, String outOfBoundsError, String notNumberError) {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (NumericUtils.isInteger(input)) {
                int inputNumber = Integer.parseInt(input);
                if (inputNumber>0 && inputNumber<=maxNumber) {
                    break;
                }
                else {
                    System.out.print(outOfBoundsError+" ");
                }
            }
            else {
                System.out.print(notNumberError+" ");
            }
        }
        return Integer.parseInt(input);
    }

}
