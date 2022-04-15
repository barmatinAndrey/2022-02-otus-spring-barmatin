package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> getAll();

    boolean exists(Author author);

    long getIdByName(Author author);

    long getNextId();

    void insert (Author author);

}
