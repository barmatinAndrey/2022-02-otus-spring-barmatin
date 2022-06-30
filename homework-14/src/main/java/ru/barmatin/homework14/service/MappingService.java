package ru.barmatin.homework14.service;

import ru.barmatin.homework14.domain.h2.BookH2;
import ru.barmatin.homework14.domain.mongo.BookMongo;

public interface MappingService {

    BookH2 bookMongoToH2(BookMongo bookMongo);

}
