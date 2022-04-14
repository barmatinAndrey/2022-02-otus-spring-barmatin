package ru.barmatin.homework05.domain;

import java.util.List;

public class Book {
    private long id;
    private String name;
    private Author author;
    private List<Genre> genreList;

    public Book(long id, String name, Author author, List<Genre> genreList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genreList = genreList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
