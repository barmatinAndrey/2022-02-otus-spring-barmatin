package ru.barmatin.homework06.repository;

import ru.barmatin.homework06.domain.Book;

import java.util.List;

public interface BookRepository {

    Book getBookById(long id);

    List<Book> getAll();

    void deleteById(long id);

    void insert(Book book);

    void update(Book book);

}
