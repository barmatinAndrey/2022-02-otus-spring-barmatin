package ru.barmatin.homework08.service.book.listconverter;

import ru.barmatin.homework08.domain.Author;
import ru.barmatin.homework08.domain.Genre;
import ru.barmatin.homework08.dto.BookDTO;

import java.util.List;

public interface ListConverterService {

    String getStringFromBookDTOList(List<BookDTO> bookDTOList);

    String getStringFromGenreList(List<Genre> genreList);

    String getStringFromAuthorList(List<Author> authorList);

}
