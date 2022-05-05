package ru.barmatin.homework08.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework08.domain.Author;


public interface AuthorRepository extends MongoRepository<Author, String> {

}
