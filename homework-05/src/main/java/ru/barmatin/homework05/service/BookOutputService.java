package ru.barmatin.homework05.service;

import ru.barmatin.homework05.domain.Book;

import java.util.List;

public interface BookOutputService {

    void showBookList(List<Book> bookList);

    void showBook(Book book);

}
