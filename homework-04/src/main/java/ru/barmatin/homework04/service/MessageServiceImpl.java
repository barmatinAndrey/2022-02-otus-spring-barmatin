package ru.barmatin.homework04.service;


import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.barmatin.homework04.config.LocaleExtractor;

import java.util.Locale;

@Service
public class MessageServiceImpl implements MessageService{
    private final MessageSource messageSource;
    private final String locale;

    public MessageServiceImpl(MessageSource messageSource, LocaleExtractor localeExtractor) {
        this.messageSource = messageSource;
        this.locale = localeExtractor.getLocale().equals("default") ? "" : localeExtractor.getLocale();
    }


    public String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.forLanguageTag(locale));
    }
}
