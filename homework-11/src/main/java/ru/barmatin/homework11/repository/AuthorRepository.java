package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework11.domain.Author;


public interface AuthorRepository extends MongoRepository<Author, String> {

}
