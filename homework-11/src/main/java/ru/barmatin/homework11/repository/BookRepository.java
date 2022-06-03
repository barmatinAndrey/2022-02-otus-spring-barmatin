package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.barmatin.homework11.domain.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Book findAllByName(String name);

}
