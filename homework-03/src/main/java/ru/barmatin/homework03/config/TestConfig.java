package ru.barmatin.homework03.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "test")
@Component
public class TestConfig implements LocaleExtractor {
    private String locale;
    private String file;
    private String extension;
    private int answersToPass;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getAnswersToPass() {
        return answersToPass;
    }

    public void setAnswersToPass(int answersToPass) {
        this.answersToPass = answersToPass;
    }

}
