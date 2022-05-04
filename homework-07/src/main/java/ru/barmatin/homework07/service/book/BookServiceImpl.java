package ru.barmatin.homework07.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.homework07.dto.BookDTO;
import ru.barmatin.homework07.repository.BookRepository;
import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.service.comment.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.barmatin.homework07.util.MappingUtils.mapBookToDTO;

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
    public BookDTO getBookById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        BookDTO bookDTO = null;
        if (book.isPresent()) {
            List<String> commentTextList = commentService.getCommentsByBookId(id);
            bookDTO = mapBookToDTO(book.get(), commentTextList);
        }
        return bookDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDTO> getAllAvailableBooks() {
        List<Book> bookList = bookRepository.findAllByOrderByName();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book: bookList) {
            bookDTOList.add(mapBookToDTO(book, new ArrayList<>()));
        }
        return bookDTOList;
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
