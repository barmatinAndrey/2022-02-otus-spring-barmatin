package ru.barmatin.homework05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework05.dao.AuthorDao;
import ru.barmatin.homework05.dao.BookDao;
import ru.barmatin.homework05.dao.GenreDao;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;


@Service
public class LibraryUpdateServiceImpl implements LibraryUpdateService {
    private final BookDao bookDao;
    private final LibraryInputService libraryInputService;

    @Autowired
    public LibraryUpdateServiceImpl(BookDao bookDao, LibraryInputService libraryInputService) {
        this.bookDao = bookDao;
        this.libraryInputService = libraryInputService;
    }

    @Override
    public void deleteBookById(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public void addNewBook() {
        Book book = libraryInputService.getNewBookFromInput();
        bookDao.insert(book);
    }

}
