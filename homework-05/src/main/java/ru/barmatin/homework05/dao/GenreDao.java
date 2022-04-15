package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.domain.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getAll();

    List<Genre> getAllUsed();

    List<Genre> getAllByName(String textToSearch);

    boolean exists(Genre genre);

    long getIdByName(Genre genre);

    long getNextId();

    void insert (Genre genre);

}
