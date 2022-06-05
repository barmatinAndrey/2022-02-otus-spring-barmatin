package ru.barmatin.homework11.mapper;

import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.dto.BookDto;

public interface BookMapper {

    BookDto mapBookToDto(Book book);
}
