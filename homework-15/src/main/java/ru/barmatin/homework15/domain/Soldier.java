package ru.barmatin.homework15.domain;

public class Soldier {
    private final String name;

    public Soldier(Person person) {
        this.name = person.getName();
    }

    public String getName() {
        return name;
    }
}
