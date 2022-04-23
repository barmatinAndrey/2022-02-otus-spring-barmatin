package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.domain.Book;

import java.util.List;

public interface BookDao {

    Book getBookById(long id);

    List<Book> getAll();

    void deleteById(long id);

    void insert(Book book);

    void update(Book book);

}
