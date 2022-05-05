package ru.barmatin.homework08.service.book;

import ru.barmatin.homework08.dto.BookDTO;

import java.util.List;

public interface BookOutputService {

    void showBookList(List<BookDTO> bookList);

    void showBook(BookDTO book);

}
