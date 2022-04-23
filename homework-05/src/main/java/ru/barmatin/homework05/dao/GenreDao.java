package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.domain.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getAll();

    List<Genre> getAllUsed();

    List<Genre> getAllByBookId(long bookId);

}
