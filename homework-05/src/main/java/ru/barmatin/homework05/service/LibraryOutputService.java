package ru.barmatin.homework05.service;

import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.List;

public interface LibraryOutputService {

    void showBookList(List<Book> bookList);

    void showGenreList(List<Genre> genreList);

    void showAuthorList(List<Author> authorList);
}
