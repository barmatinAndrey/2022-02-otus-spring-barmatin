package ru.barmatin.homework06.service;

import ru.barmatin.homework06.domain.Author;
import ru.barmatin.homework06.domain.Book;
import ru.barmatin.homework06.domain.Comment;
import ru.barmatin.homework06.domain.Genre;

import java.util.List;

public interface ListConverterService {

    String getStringFromBookList(List<Book> bookList);

    String getStringFromGenreList(List<Genre> genreList);

    String getStringFromAuthorList(List<Author> authorList);

    String getStringFromCommentList(List<Comment> commentList);
}
