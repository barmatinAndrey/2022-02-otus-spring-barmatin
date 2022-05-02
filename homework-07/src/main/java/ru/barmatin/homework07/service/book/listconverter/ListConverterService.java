package ru.barmatin.homework07.service.book.listconverter;

import ru.barmatin.homework07.domain.Author;
import ru.barmatin.homework07.domain.Genre;
import ru.barmatin.homework07.dto.BookDTO;

import java.util.List;

public interface ListConverterService {

    String getStringFromBookDTOList(List<BookDTO> bookDTOList);

    String getStringFromGenreList(List<Genre> genreList);

    String getStringFromAuthorList(List<Author> authorList);

}
