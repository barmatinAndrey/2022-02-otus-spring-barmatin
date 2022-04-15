package ru.barmatin.homework05.service;

import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.List;

public interface ListConverterService {

    String getStringFromBookList(List<Book> bookList);

    String getStringFromGenreList(List<Genre> genreList);

    String getStringFromAuthorList(List<Author> authorList);

}
