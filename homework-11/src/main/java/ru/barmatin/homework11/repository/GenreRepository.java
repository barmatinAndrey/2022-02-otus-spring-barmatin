package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.barmatin.homework11.domain.Genre;


public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

}
