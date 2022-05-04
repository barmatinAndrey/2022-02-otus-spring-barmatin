package ru.barmatin.homework07.service.book;

import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.dto.BookDTO;

import java.util.List;

public interface BookOutputService {

    void showBookList(List<BookDTO> bookList);

    void showBook(BookDTO book);

}
