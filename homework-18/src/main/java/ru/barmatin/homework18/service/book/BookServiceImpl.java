package ru.barmatin.homework18.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.homework18.dto.BookDto;
import ru.barmatin.homework18.repository.BookRepository;
import ru.barmatin.homework18.domain.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static ru.barmatin.homework18.util.MappingUtils.mapBookToDto;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDto> getAllAvailableBooksDto() {
        List<Book> bookList = bookRepository.findAllByOrderByName();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book: bookList) {
            bookDtoList.add(mapBookToDto(book));
        }
        return bookDtoList;
    }

    @Transactional
    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

}
