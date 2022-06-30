package ru.barmatin.homework14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework14.domain.h2.AuthorH2;
import ru.barmatin.homework14.domain.h2.BookH2;
import ru.barmatin.homework14.domain.h2.GenreH2;
import ru.barmatin.homework14.domain.mongo.AuthorMongo;
import ru.barmatin.homework14.domain.mongo.BookMongo;
import ru.barmatin.homework14.domain.mongo.GenreMongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MappingServiceImpl implements MappingService {
    private Long authorCount = 1L;
    private final HashMap<String, Long> authorMap;
    private Long genreCount = 1L;
    private final HashMap<String, Long> genreMap;

    @Autowired
    public MappingServiceImpl() {
        authorMap = new HashMap<>();
        genreMap = new HashMap<>();
    }

    public AuthorH2 authorMongoToH2(AuthorMongo authorMongo){
        AuthorH2 authorH2 = new AuthorH2(authorCount, authorMongo.getSurname(), authorMongo.getName(), authorMongo.getPatronym());
        authorMap.put(authorMongo.getId(), authorH2.getId());
        authorCount++;
        return authorH2;
    }

    public GenreH2 genreMongoToH2(GenreMongo genreMongo){
        GenreH2 genreH2 = new GenreH2(genreCount, genreMongo.getName());
        genreMap.put(genreMongo.getId(), genreH2.getId());
        genreCount++;
        return genreH2;
    }

    public BookH2 bookMongoToH2(BookMongo bookMongo){
        AuthorH2 authorH2 = new AuthorH2(
                authorMap.get(bookMongo.getAuthorMongo().getId()),
                bookMongo.getAuthorMongo().getSurname(),
                bookMongo.getAuthorMongo().getName(),
                bookMongo.getAuthorMongo().getPatronym());
        List<GenreH2> genreH2List = new ArrayList<>();
        for (GenreMongo genreMongo: bookMongo.getGenreMongoList()) {
            genreH2List.add(new GenreH2(
                    genreMap.get(genreMongo.getId()),
                    genreMongo.getName()
            ));
        }
        return new BookH2(bookMongo.getName(), authorH2, genreH2List);
    }
}
