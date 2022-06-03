package ru.barmatin.homework11.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.barmatin.homework11.dto.BookDto;
import ru.barmatin.homework11.mapper.BookMapper;
import ru.barmatin.homework11.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/api/book")
    public Flux<BookDto> getAllBooksDto() {
        return bookRepository.findAll()
                .map(book -> bookMapper.mapBookToDto(book));
    }

    @DeleteMapping("/api/book")
    public void deleteBook(@RequestParam("id") String id) {
//        bookService.deleteBookById(id);
    }

}
