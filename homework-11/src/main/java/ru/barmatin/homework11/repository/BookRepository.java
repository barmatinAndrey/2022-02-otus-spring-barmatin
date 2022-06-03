package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework11.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findAllByName(String name);

}
