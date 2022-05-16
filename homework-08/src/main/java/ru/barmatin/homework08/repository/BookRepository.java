package ru.barmatin.homework08.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework08.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findAllByName(String name);

}
