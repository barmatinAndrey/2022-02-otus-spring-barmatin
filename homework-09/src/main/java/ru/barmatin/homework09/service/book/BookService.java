package ru.barmatin.homework09.service.book;

import ru.barmatin.homework09.domain.Book;
import ru.barmatin.homework09.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookDto getBookDtoById(long id);

    Optional<Book> getBookById(long id);

    List<BookDto> getAllAvailableBooksDto();

    void deleteBookById(long id);

    void saveBook(Book book);

}
