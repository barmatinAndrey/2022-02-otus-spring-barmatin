package ru.barmatin.homework03.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.barmatin.homework03.util.ApplicationUtils;

import java.util.Scanner;

import static ru.barmatin.homework03.util.ApplicationUtils.getSourceMsg;

@Service
public class IOServiceImpl implements IOService {
    private final Scanner scanner;
    private final MessageSource messageSource;

    public IOServiceImpl(MessageSource messageSource) {
        this.scanner = new Scanner(System.in);
        this.messageSource = messageSource;
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
                    System.out.print(getSourceMsg(messageSource, "strings.number.out.of.bounds")+" ");
                }
            }
            else {
                System.out.print(getSourceMsg(messageSource, "strings.not.number")+" ");
            }
        }
        return Integer.parseInt(input);
    }

}
