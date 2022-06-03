package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework11.domain.Genre;


public interface GenreRepository extends MongoRepository<Genre, String> {

}
