package ru.barmatin.homework09.service.book;

import ru.barmatin.homework09.dto.BookDto;

import java.util.List;

public interface BookOutputService {

    void showBookList(List<BookDto> bookList);

    void showBook(BookDto book);

}
