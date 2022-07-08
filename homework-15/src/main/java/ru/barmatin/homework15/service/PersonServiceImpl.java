package ru.barmatin.homework15.service;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework15.domain.Person;
import ru.barmatin.homework15.integration.MilitaryOffice;

@Service
public class PersonServiceImpl implements PersonService {
    private static final String[] NAMES = {"Ivan", "Petr", "Andrey",
            "Konstantin", "Aleksandr", "Evgeniy", "Artem", "Vladislav"};

    private final MilitaryOffice militaryOffice;

    @Autowired
    public PersonServiceImpl(MilitaryOffice militaryOffice) {
        this.militaryOffice = militaryOffice;
    }

    @SuppressWarnings({"resource", "Duplicates", "InfiniteLoopStatement", "BusyWait"})
    @Override
    public void startPeopleLoop() throws Exception {
        while (true) {
            Thread.sleep(3000);
            Person person = generatePerson();
            System.out.println("New person: " + person.getName() +
                    ", age: " + person.getAge() + ", isIll: " + person.isIll());
            militaryOffice.check(person);
        }
    }

    private Person generatePerson() {
        return new Person(NAMES[RandomUtils.nextInt(0,NAMES.length)],
                RandomUtils.nextInt(15, 30),
                RandomUtils.nextBoolean());
    }

}
