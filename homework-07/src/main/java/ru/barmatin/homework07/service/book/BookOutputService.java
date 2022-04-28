package ru.barmatin.homework07.service.book;

import ru.barmatin.homework07.domain.Book;

import java.util.List;

public interface BookOutputService {

    void showBookList(List<Book> bookList);

    void showBook(Book book);

}
