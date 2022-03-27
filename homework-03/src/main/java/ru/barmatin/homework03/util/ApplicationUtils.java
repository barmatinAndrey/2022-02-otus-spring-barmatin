package ru.barmatin.homework03.util;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class ApplicationUtils {
    public static final String LOCALE_TAG = "ru";

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public static String getSourceMsg(MessageSource messageSource, String code) {
        return messageSource.getMessage(code, null, Locale.forLanguageTag(LOCALE_TAG));
    }

}
