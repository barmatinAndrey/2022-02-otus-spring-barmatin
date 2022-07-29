package ru.barmatin.homework18.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.homework18.dto.BookDto;
import ru.barmatin.homework18.service.hystrix.HystrixCallService;
import java.util.List;

@RestController
public class BookController {
    private final HystrixCallService hystrixCallService;

    @Autowired
    public BookController(HystrixCallService hystrixCallService) {
        this.hystrixCallService = hystrixCallService;
    }

    @GetMapping("/api/book")
    public List<BookDto> getAllBooksDto() {
        return hystrixCallService.getAllBooksDto();
    }

    @DeleteMapping("/api/book/delete")
    public void deleteBook(@RequestParam("id") long id) {
        hystrixCallService.deleteBook(id);
    }

}
