package ru.barmatin.homework14.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework14.domain.mongo.AuthorMongo;


public interface AuthorMongoRepository extends MongoRepository<AuthorMongo, String> {

}
