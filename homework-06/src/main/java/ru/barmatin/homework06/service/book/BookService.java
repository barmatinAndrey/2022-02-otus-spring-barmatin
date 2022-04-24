package ru.barmatin.homework06.service.book;

import ru.barmatin.homework06.domain.Book;

import java.util.List;

public interface BookService {

    Book getBookById(long id);

    List<Book> getAllAvailableBooks();

    void deleteBookById(long id);

    void addNewBook(Book book);

    void editBook(Book book);

}
