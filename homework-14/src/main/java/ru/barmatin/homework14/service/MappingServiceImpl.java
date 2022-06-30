package ru.barmatin.homework14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework14.domain.h2.AuthorH2;
import ru.barmatin.homework14.domain.h2.BookH2;
import ru.barmatin.homework14.domain.h2.GenreH2;
import ru.barmatin.homework14.domain.mongo.BookMongo;
import ru.barmatin.homework14.domain.mongo.GenreMongo;
import ru.barmatin.homework14.repository.h2.AuthorH2Repository;
import ru.barmatin.homework14.repository.h2.GenreH2Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MappingServiceImpl implements MappingService {
    private final AuthorH2Repository authorH2Repository;
    private final GenreH2Repository genreH2Repository;


    @Autowired
    public MappingServiceImpl(AuthorH2Repository authorH2Repository, GenreH2Repository genreH2Repository) {
        this.authorH2Repository = authorH2Repository;
        this.genreH2Repository = genreH2Repository;
    }

    public BookH2 bookMongoToH2(BookMongo bookMongo){
        Optional<AuthorH2> authorH2Optional = authorH2Repository.findBySurnameAndNameAndPatronym(
                bookMongo.getAuthorMongo().getSurname(),
                bookMongo.getAuthorMongo().getName(),
                bookMongo.getAuthorMongo().getPatronym());
        AuthorH2 authorH2 = authorH2Optional.orElseGet(
                () -> authorH2Repository.save(new AuthorH2(
                    bookMongo.getAuthorMongo().getSurname(),
                    bookMongo.getAuthorMongo().getName(),
                    bookMongo.getAuthorMongo().getPatronym())));

        List<GenreH2> genreH2List = new ArrayList<>();
        for (GenreMongo genreMongo: bookMongo.getGenreMongoList()) {
            Optional<GenreH2> genreH2Optional = genreH2Repository.findByName(
                    genreMongo.getName());
            GenreH2 genreH2 = genreH2Optional.orElseGet(
                    () -> genreH2Repository.save(new GenreH2(genreMongo.getName())));
            genreH2List.add(genreH2);
        }
        return new BookH2(bookMongo.getName(), authorH2, genreH2List);
    }
}
