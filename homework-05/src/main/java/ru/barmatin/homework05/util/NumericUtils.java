package ru.barmatin.homework05.util;

public class NumericUtils {

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
