package ru.barmatin.homework05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework05.dao.AuthorDao;
import ru.barmatin.homework05.dao.BookDao;
import ru.barmatin.homework05.dao.GenreDao;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.List;

@Service
public class LibraryGetServiceImpl implements LibraryGetService {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Autowired
    public LibraryGetServiceImpl(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getAllBooksByAuthorNameContains(String text) {
        return bookDao.getAllByAuthorNameContains(text);
    }

    @Override
    public List<Book> getAllBooksByBookNameContains(String text) {
        return bookDao.getAllByBookNameContains(text);
    }

    @Override
    public List<Book> getAllBooksByGenreNameContains(String text) {
        return bookDao.getAllByGenreNameContains(text);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

}
