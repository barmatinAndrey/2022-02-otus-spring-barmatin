package ru.barmatin.homework14.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.barmatin.homework14.domain.mongo.AuthorMongo;
import ru.barmatin.homework14.domain.mongo.BookMongo;
import ru.barmatin.homework14.domain.mongo.GenreMongo;
import ru.barmatin.homework14.repository.mongo.AuthorMongoRepository;
import ru.barmatin.homework14.repository.mongo.BookMongoRepository;
import ru.barmatin.homework14.repository.mongo.GenreMongoRepository;

import java.util.List;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "barmatin", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertBooks", author = "barmatin")
    public void insertBooks(AuthorMongoRepository authorRepository, GenreMongoRepository genreRepository,
                            BookMongoRepository bookRepository) {
        AuthorMongo authorMongo = authorRepository.save(new AuthorMongo("Достоевский", "Федор", "Михайлович"));
        AuthorMongo authorMongo1 = authorRepository.save(new AuthorMongo("Маркес", "Габриэль Гарсия", ""));
        AuthorMongo authorMongo2 = authorRepository.save(new AuthorMongo("Дюморье", "Дафна", ""));
        AuthorMongo authorMongo3 = authorRepository.save(new AuthorMongo("Готтлиб", "Лори", ""));
        AuthorMongo authorMongo4 = authorRepository.save(new AuthorMongo("Тартт", "Дона", ""));

        GenreMongo genreMongo = genreRepository.save(new GenreMongo("роман"));
        GenreMongo genreMongo1 = genreRepository.save(new GenreMongo("магический реализм"));
        GenreMongo genreMongo2 = genreRepository.save(new GenreMongo("триллер"));
        GenreMongo genreMongo3 = genreRepository.save(new GenreMongo("детектив"));
        GenreMongo genreMongo4 = genreRepository.save(new GenreMongo("трагедия"));
        GenreMongo genreMongo5 = genreRepository.save(new GenreMongo("психология"));
        GenreMongo genreMongo6 = genreRepository.save(new GenreMongo("фантастика"));

        BookMongo bookMongo = bookRepository.save(new BookMongo("Вы хотите поговорить об этом?", authorMongo3, List.of(genreMongo5)));
        BookMongo bookMongo1 = bookRepository.save(new BookMongo("100 лет одиночества", authorMongo1, List.of(genreMongo, genreMongo1)));
        BookMongo bookMongo2 = bookRepository.save(new BookMongo("Щегол", authorMongo4, List.of(genreMongo, genreMongo2, genreMongo4, genreMongo6)));
        BookMongo bookMongo3 = bookRepository.save(new BookMongo("Ребекка", authorMongo2, List.of(genreMongo, genreMongo2, genreMongo3, genreMongo4)));
        BookMongo bookMongo4 = bookRepository.save(new BookMongo("Преступление и наказание", authorMongo, List.of(genreMongo)));

    }


}
