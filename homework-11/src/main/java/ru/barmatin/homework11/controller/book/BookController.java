package ru.barmatin.homework11.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.dto.BookDto;
import ru.barmatin.homework11.mapper.BookMapper;
import ru.barmatin.homework11.repository.BookRepository;

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
        return bookRepository.findAll(Sort.by("name"))
                .map(book -> bookMapper.mapBookToDto(book));
    }

    @DeleteMapping("/api/book")
    public Mono<Void> deleteBook(@RequestParam("id") String id) {
        return bookRepository.deleteById(id);
    }

//    @PostMapping(value = "/book/edit", consumes = {"application/json"})
//    public void saveBook(@RequestBody Mono<Book> bookMono) {
//        bookMono.map(book -> {
//            if (book.getId().isEmpty()) {
//                book.setId(null);
//            }
//            bookRepository.save(book);
//            return "redirect:/";
//        }).subscribe();
//    }
////В этом методе возвращается ошибка: There was an unexpected error (type=Unsupported Media Type, status=415)

}
