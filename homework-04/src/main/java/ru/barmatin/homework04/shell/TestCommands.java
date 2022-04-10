package ru.barmatin.homework04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.barmatin.homework04.service.MessageService;
import ru.barmatin.homework04.service.TestService;

@ShellComponent
public class TestCommands {
    private final TestService testService;
    private final MessageService messageService;
    private String userName;

    @Autowired
    public TestCommands(TestService testService, MessageService messageService) {
        this.testService = testService;
        this.messageService = messageService;
    }

    @ShellMethod(value = "Enter user name", key = {"e", "enter", "enter-user-name"})
    public void enterUserName(String userName) {
        this.userName = userName;
    }

    @ShellMethod(value = "Start test", key = {"s", "start", "start-test"})
    @ShellMethodAvailability(value = "isTestCanBeStarted")
    public void startTest() {
        testService.startTest(userName);
    }

    private Availability isTestCanBeStarted() {
        return userName == null ? Availability.unavailable(messageService.getMessage("strings.enter.name")) : Availability.available();
    }

}
