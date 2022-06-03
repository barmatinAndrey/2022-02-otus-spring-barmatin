package ru.barmatin.homework11.service.book;

import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getBookById(String id);

    BookDto getBookDtoById(String id);

    List<BookDto> getAllAvailableBooksDto();

    void deleteBookById(String id);

    void saveBook(Book book);

}
