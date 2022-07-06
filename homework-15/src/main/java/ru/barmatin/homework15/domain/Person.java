package ru.barmatin.homework15.domain;

public class Person {
    private final String name;
    private final int age;
    private final boolean isIll;

    public Person(String name, int age, boolean isIll) {
        this.name = name;
        this.age = age;
        this.isIll = isIll;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isIll() {
        return isIll;
    }
}
