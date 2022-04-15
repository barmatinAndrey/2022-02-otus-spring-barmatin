package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.dao.ext.BookGenreRelation;
import ru.barmatin.homework05.domain.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAll();

    List<Book> getAllByAuthorNameContains(String textToSearch);

    List<Book> getAllByBookNameContains(String textToSearch);

    List<Book> getAllByGenreNameContains(String genreName);

    void deleteById(long id);

    long getNextId();

    void insert(Book book);

}
