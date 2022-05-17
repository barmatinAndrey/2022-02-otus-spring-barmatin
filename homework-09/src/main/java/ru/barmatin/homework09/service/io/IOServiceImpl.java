package ru.barmatin.homework09.service.io;

import org.springframework.stereotype.Service;
import ru.barmatin.homework09.util.NumericUtils;

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

    @Override
    public int readInt(String notNumberError) {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (NumericUtils.isInteger(input)) {
                break;
            }
            else {
                System.out.print(notNumberError+" ");
            }
        }
        return Integer.parseInt(input);
    }
}
