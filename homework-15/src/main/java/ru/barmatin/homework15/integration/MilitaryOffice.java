package ru.barmatin.homework15.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.barmatin.homework15.domain.Person;
import ru.barmatin.homework15.domain.Soldier;

import java.util.Collection;

@MessagingGateway
public interface MilitaryOffice {

    @Gateway(requestChannel = "peopleChannel", replyChannel = "soldiersChannel")
    Soldier process(Person person);

}
