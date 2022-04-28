package ru.barmatin.homework07.service.book;

import ru.barmatin.homework07.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getBookById(long id);

    List<Book> getAllAvailableBooks();

    void deleteBookById(long id);

    void saveBook(Book book);

}
