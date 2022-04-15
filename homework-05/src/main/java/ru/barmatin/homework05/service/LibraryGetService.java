package ru.barmatin.homework05.service;

import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.List;

public interface LibraryGetService {

    List<Book> getAllAvailableBooks();

    List<Book> getAllBooksByAuthorNameContains(String text);

    List<Book> getAllBooksByBookNameContains(String text);

    List<Book> getAllBooksByGenreNameContains(String text);

    List<Genre> getAllGenres();

    List<Author> getAllAuthors();

}
