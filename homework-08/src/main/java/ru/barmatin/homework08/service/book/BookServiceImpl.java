package ru.barmatin.homework08.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.barmatin.homework08.domain.Comment;
import ru.barmatin.homework08.dto.BookDTO;
import ru.barmatin.homework08.repository.BookRepository;
import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.service.comment.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CommentService commentService;
    private final BookMappingService bookMappingService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CommentService commentService, BookMappingService bookMappingService) {
        this.bookRepository = bookRepository;
        this.commentService = commentService;
        this.bookMappingService = bookMappingService;
    }

    @Override
    public BookDTO getBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        BookDTO bookDTO = null;
        if (book.isPresent()) {
            List<Comment> commentList = commentService.getCommentsByBookId(id);
            bookDTO = bookMappingService.mapBookToDTO(book.get(), commentList);
        }
        return bookDTO;
    }

    @Override
    public List<BookDTO> getAllAvailableBooks() {
        List<Book> bookList = bookRepository.findAll(Sort.by("name"));
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book: bookList) {
            bookDTOList.add(bookMappingService.mapBookToDTO(book, new ArrayList<>()));
        }
        return bookDTOList;
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
        commentService.deleteCommentByBookId(id);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

}
