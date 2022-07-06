package ru.barmatin.homework14.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "books")
public class BookMongo {
    @Id
    private String id;
    private String name;
    private AuthorMongo authorMongo;
    private List<GenreMongo> genreMongoList;

    public BookMongo(String name, AuthorMongo authorMongo, List<GenreMongo> genreMongoList) {
        this.name = name;
        this.authorMongo = authorMongo;
        this.genreMongoList = genreMongoList;
    }
}
