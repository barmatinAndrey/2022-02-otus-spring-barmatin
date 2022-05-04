package ru.barmatin.homework07.service.book;

import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookDTO getBookById(long id);

    List<BookDTO> getAllAvailableBooks();

    void deleteBookById(long id);

    void saveBook(Book book);

}
