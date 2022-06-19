package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.barmatin.homework11.domain.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Mono<Book> save(Mono<Book> bookMono);

}
