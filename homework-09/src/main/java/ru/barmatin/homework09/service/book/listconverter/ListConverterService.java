package ru.barmatin.homework09.service.book.listconverter;

import ru.barmatin.homework09.domain.Author;
import ru.barmatin.homework09.domain.Genre;
import ru.barmatin.homework09.dto.BookDto;

import java.util.List;

public interface ListConverterService {

    String getStringFromBookDTOList(List<BookDto> bookDtoList);

    String getStringFromGenreList(List<Genre> genreList);

    String getStringFromAuthorList(List<Author> authorList);

}
