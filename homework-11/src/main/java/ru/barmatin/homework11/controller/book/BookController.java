package ru.barmatin.homework11.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.barmatin.homework11.domain.Author;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.domain.Genre;
import ru.barmatin.homework11.dto.BookDto;
import ru.barmatin.homework11.mapper.BookMapper;
import ru.barmatin.homework11.repository.AuthorRepository;
import ru.barmatin.homework11.repository.BookRepository;
import ru.barmatin.homework11.repository.GenreRepository;

@RestController
public class
BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/api/books")
    public Flux<BookDto> getAllBooksDto() {
        return bookRepository.findAll(Sort.by("name"))
                .map(book -> bookMapper.mapBookToDto(book));
    }

    @GetMapping("/api/book")
    public Mono<Book> getBook(@RequestParam("id") String id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/api/authors")
    public Flux<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/api/genres")
    public Flux<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @DeleteMapping("/api/book")
    public Mono<Void> deleteBook(@RequestParam("id") String id) {
        return bookRepository.deleteById(id);
    }

    @PostMapping(value = "/book/edit", consumes = {"application/json"})
    public Mono<Book> saveBook(@RequestBody Book bookMono) {
        return bookRepository.save(bookMono);
    }


}
