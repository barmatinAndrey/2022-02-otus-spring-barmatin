package ru.barmatin.homework18.service.hystrix;

import ru.barmatin.homework18.domain.Author;
import ru.barmatin.homework18.domain.Book;
import ru.barmatin.homework18.domain.Genre;
import ru.barmatin.homework18.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface HystrixCallService {

    Optional<Book> getBookById(long id);

    List<BookDto> getAllBooksDto();

    void deleteBook(long id);

    void saveBook(Book book);

    List<Author> getAllAuthors();

    List<Genre> getAllGenres();

}
