package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.barmatin.homework11.domain.Author;


public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

}
