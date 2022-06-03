package ru.barmatin.homework11.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.domain.Comment;
import ru.barmatin.homework11.dto.BookDto;
import ru.barmatin.homework11.repository.BookRepository;
import ru.barmatin.homework11.service.comment.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.barmatin.homework11.util.MappingUtils.mapBookToDto;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CommentService commentService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CommentService commentService) {
        this.bookRepository = bookRepository;
        this.commentService = commentService;
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public BookDto getBookDtoById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        BookDto bookDto = null;
        if (book.isPresent()) {
            List<Comment> commentList = commentService.getCommentsByBookId(id);
            bookDto = mapBookToDto(book.get(), commentList);
        }
        return bookDto;
    }

    @Override
    public List<BookDto> getAllAvailableBooksDto() {
        List<Book> bookList = bookRepository.findAll(Sort.by("name"));
        List<BookDto> bookDTOList = new ArrayList<>();
        for (Book book: bookList) {
            bookDTOList.add(mapBookToDto(book, new ArrayList<>()));
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
