package ru.barmatin.homework15.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.barmatin.homework15.domain.Person;

@MessagingGateway
public interface MilitaryOffice {

    @Gateway(requestChannel = "peopleChannel", replyChannel = "soldiersChannel")
    void check(Person person);

}
