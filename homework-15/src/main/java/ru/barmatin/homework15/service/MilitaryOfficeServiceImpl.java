package ru.barmatin.homework15.service;

import org.springframework.stereotype.Service;
import ru.barmatin.homework15.domain.Person;
import ru.barmatin.homework15.domain.Soldier;

@Service
public class MilitaryOfficeServiceImpl implements MilitaryOfficeService {

    public Soldier draft(Person person) {
        return new Soldier(person);
    }

}
