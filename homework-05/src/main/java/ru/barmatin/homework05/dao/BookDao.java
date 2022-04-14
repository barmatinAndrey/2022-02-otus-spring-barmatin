package ru.barmatin.homework05.dao;

import ru.barmatin.homework05.dao.ext.BookGenreRelation;
import ru.barmatin.homework05.domain.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAll();

    List<Book> getAllByAuthorName(String textToSearch);

    List<Book> getAllByBookName(String textToSearch);

    List<Book> getAllByGenre(String genreName);

    void deleteById(long id);

    long count();

    void insert (BookGenreRelation bookGenreRelation);

    void insert (Book book);

}
