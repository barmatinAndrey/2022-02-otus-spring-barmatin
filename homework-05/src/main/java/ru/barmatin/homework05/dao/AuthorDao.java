package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> getAll();

    long getCountByName(String surname, String name, String patronym);

    long getIdByName(String surname, String name, String patronym);

    long count();

    void insert (Author author);

}
