package ru.barmatin.homework08.service.book;

import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO getBookById(String id);

    List<BookDTO> getAllAvailableBooks();

    void deleteBookById(String id);

    void saveBook(Book book);

}
