package ru.barmatin.homework06.service.book;

import ru.barmatin.homework06.domain.Book;

import java.util.List;

public interface BookOutputService {

    void showBookList(List<Book> bookList);

    void showBook(Book book);

}
