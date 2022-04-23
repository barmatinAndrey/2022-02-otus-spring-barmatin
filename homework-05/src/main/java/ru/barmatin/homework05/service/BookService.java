package ru.barmatin.homework05.service;

import ru.barmatin.homework05.domain.Book;

import java.util.List;

public interface BookService {

    Book getBookById(long id);

    List<Book> getAllAvailableBooks();

    void deleteBookById(long id);

    void addNewBook(Book book);

    void editBook(Book book);

}
