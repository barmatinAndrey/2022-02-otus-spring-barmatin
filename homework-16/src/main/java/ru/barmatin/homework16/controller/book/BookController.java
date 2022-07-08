package ru.barmatin.homework16.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.homework16.dto.BookDto;
import ru.barmatin.homework16.service.book.BookService;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/book")
    public List<BookDto> getAllBooksDto() {
        return bookService.getAllAvailableBooksDto();
    }

    @DeleteMapping("/api/book/delete")
    public void deleteBook(@RequestParam("id") long id) {
        bookService.deleteBookById(id);
    }

}
