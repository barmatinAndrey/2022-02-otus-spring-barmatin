package ru.barmatin.homework07.service.listconverter;

import ru.barmatin.homework07.domain.Author;
import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.domain.Comment;
import ru.barmatin.homework07.domain.Genre;

import java.util.List;

public interface ListConverterService {

    String getStringFromBookList(List<Book> bookList);

    String getStringFromGenreList(List<Genre> genreList);

    String getStringFromAuthorList(List<Author> authorList);

    String getStringFromCommentList(List<Comment> commentList);
}
