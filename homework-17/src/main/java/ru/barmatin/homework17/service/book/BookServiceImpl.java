package ru.barmatin.homework17.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.homework17.dto.BookDto;
import ru.barmatin.homework17.repository.BookRepository;
import ru.barmatin.homework17.domain.Book;
import ru.barmatin.homework17.service.comment.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.barmatin.homework17.util.MappingUtils.mapBookToDto;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CommentService commentService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CommentService commentService) {
        this.bookRepository = bookRepository;
        this.commentService = commentService;
    }

    @Transactional(readOnly = true)
    @Override
    public BookDto getBookDtoById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        BookDto bookDTO = null;
        if (book.isPresent()) {
            List<String> commentTextList = commentService.getCommentsByBookId(id);
            bookDTO = mapBookToDto(book.get(), commentTextList);
        }
        return bookDTO;
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
            bookDtoList.add(mapBookToDto(book, new ArrayList<>()));
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
