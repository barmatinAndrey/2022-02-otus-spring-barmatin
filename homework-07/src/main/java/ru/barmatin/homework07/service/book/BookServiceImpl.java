package ru.barmatin.homework07.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework07.repository.BookRepository;
import ru.barmatin.homework07.domain.Book;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return bookRepository.findAllByOrderByName();
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

}
