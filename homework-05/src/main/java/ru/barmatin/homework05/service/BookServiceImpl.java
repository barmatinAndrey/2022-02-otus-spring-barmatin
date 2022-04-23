package ru.barmatin.homework05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework05.dao.BookDao;
import ru.barmatin.homework05.domain.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return bookDao.getAll();
    }

    @Override
    public void deleteBookById(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public void addNewBook(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void editBook(Book book) {
        bookDao.update(book);
    }
}
