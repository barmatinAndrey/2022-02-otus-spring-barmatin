package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.domain.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getAll();

    List<Genre> getAllUsed();

    List<Genre> getAllByName(String textToSearch);

    long getCountByName(String name);

    long getIdByName(String name);

    long count();

    void insert (Genre genre);

}
