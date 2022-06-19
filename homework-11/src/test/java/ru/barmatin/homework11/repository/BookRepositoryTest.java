package ru.barmatin.homework11.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Flux;
import ru.barmatin.homework11.domain.Author;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.repository.BookRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;

@DataMongoTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void getAll() {
        bookRepository.saveAll(Arrays.asList(
                    new Book("Вы хотите поговорить об этом?", new Author(), new ArrayList<>()),
                    new Book("100 лет одиночества", new Author(), new ArrayList<>()),
                    new Book("Щегол", new Author(), new ArrayList<>()),
                    new Book("Ребекка", new Author(), new ArrayList<>()),
                    new Book("Преступление и наказание", new Author(), new ArrayList<>()))
                )
                .doOnComplete(() -> {
                    Flux<Book> bookFlux = bookRepository.findAll();
                    StepVerifier
                            .create(bookFlux)
                            .assertNext(book -> assertEquals("100 лет одиночества", book.getName()))
                            .assertNext(book -> assertEquals("Вы хотите поговорить об этом?", book.getName()))
                            .assertNext(book -> assertEquals("Преступление и наказание", book.getName()))
                            .assertNext(book -> assertEquals("Ребекка", book.getName()))
                            .assertNext(book -> assertEquals("Щегол", book.getName()))
                            .expectComplete()
                            .verify();
                })
                .subscribe();

    }
}