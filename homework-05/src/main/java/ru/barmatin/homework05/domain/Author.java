package ru.barmatin.homework05.domain;

public class Author {
    private long id;
    private String surname;
    private String name;
    private String patronym;

    public Author(long id, String surname, String name, String patronym) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }
}
