package ru.barmatin.homework14.service;

import ru.barmatin.homework14.domain.h2.AuthorH2;
import ru.barmatin.homework14.domain.h2.BookH2;
import ru.barmatin.homework14.domain.h2.GenreH2;
import ru.barmatin.homework14.domain.mongo.AuthorMongo;
import ru.barmatin.homework14.domain.mongo.BookMongo;
import ru.barmatin.homework14.domain.mongo.GenreMongo;

public interface MappingService {

    AuthorH2 authorMongoToH2(AuthorMongo authorMongo);

    GenreH2 genreMongoToH2(GenreMongo genreMongo);

    BookH2 bookMongoToH2(BookMongo bookMongo);

}
