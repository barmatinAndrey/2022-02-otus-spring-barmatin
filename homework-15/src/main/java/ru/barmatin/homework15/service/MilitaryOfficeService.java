package ru.barmatin.homework15.service;

import ru.barmatin.homework15.domain.Person;
import ru.barmatin.homework15.domain.Soldier;

public interface MilitaryOfficeService {

    Soldier draft(Person person);

}
