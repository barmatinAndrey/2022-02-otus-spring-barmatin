package ru.barmatin.homework08.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework08.domain.Genre;


public interface GenreRepository extends MongoRepository<Genre, String> {

}
