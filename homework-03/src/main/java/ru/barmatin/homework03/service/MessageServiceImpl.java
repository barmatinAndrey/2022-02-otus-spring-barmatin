package ru.barmatin.homework03.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageServiceImpl implements MessageService{
    private final MessageSource messageSource;
    private final String locale;

    public MessageServiceImpl(MessageSource messageSource, @Value("${test.locale}") String locale) {
        this.messageSource = messageSource;
        this.locale = locale.equals("default") ? "" : locale;
    }


    public String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.forLanguageTag(locale));
    }
}
