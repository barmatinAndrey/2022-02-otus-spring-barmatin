package ru.barmatin.homework14.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework14.domain.mongo.BookMongo;

public interface BookMongoRepository extends MongoRepository<BookMongo, String> {

}
