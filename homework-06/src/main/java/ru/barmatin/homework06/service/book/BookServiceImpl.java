package ru.barmatin.homework06.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.repository.BookRepository;
import ru.barmatin.homework06.domain.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return bookRepository.getAll();
    }

    @Transactional
    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addNewBook(Book book) {
        bookRepository.insert(book);
    }

    @Transactional
    @Override
    public void editBook(Book book) {
        bookRepository.update(book);
    }
}
