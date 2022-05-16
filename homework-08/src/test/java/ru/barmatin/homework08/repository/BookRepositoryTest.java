package ru.barmatin.homework08.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoOperations;
import ru.barmatin.homework08.domain.Author;
import ru.barmatin.homework08.domain.Book;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoOperations mongoOperations;


    @Test
    void addNewBook() {
        Book book = mongoOperations.insert(new Book("Идиот", new Author(), new ArrayList<>()));
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        assertThat(optionalBook).isNotEmpty()
                .get()
                .extracting(Book::getName).isEqualTo("Идиот");
    }
}