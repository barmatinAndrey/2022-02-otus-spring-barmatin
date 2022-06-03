package ru.barmatin.homework11.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.reactivestreams.client.MongoDatabase;
import reactor.core.publisher.Mono;
import ru.barmatin.homework11.domain.Author;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.domain.Genre;
import ru.barmatin.homework11.repository.AuthorRepository;
import ru.barmatin.homework11.repository.BookRepository;
import ru.barmatin.homework11.repository.GenreRepository;

import java.util.List;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "barmatin", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertBooks", author = "barmatin")
    public void insertBooks(AuthorRepository authorRepository, GenreRepository genreRepository,
                            BookRepository bookRepository) {
        Mono<Author> author = authorRepository.save(new Author("Достоевский", "Федор", "Михайлович"));
        Mono<Author> author1 = authorRepository.save(new Author("Маркес", "Габриэль Гарсия", ""));
        Mono<Author> author2 = authorRepository.save(new Author("Дюморье", "Дафна", ""));
        Mono<Author> author3 = authorRepository.save(new Author("Готтлиб", "Лори", ""));
        Mono<Author> author4 = authorRepository.save(new Author("Тартт", "Дона", ""));

        Mono<Genre> genre = genreRepository.save(new Genre("роман"));
        Mono<Genre> genre1 = genreRepository.save(new Genre("магический реализм"));
        Mono<Genre> genre2 = genreRepository.save(new Genre("триллер"));
        Mono<Genre> genre3 = genreRepository.save(new Genre("детектив"));
        Mono<Genre> genre4 = genreRepository.save(new Genre("трагедия"));
        Mono<Genre> genre5 = genreRepository.save(new Genre("психология"));
        Mono<Genre> genre6 = genreRepository.save(new Genre("фантастика"));

        Mono<Book> book = bookRepository.save(new Book("Вы хотите поговорить об этом?", author3.block(), List.of(genre5.block())));
        Mono<Book> book1 = bookRepository.save(new Book("100 лет одиночества", author1.block(), List.of(genre.block(), genre1.block())));
        Mono<Book> book2 = bookRepository.save(new Book("Щегол", author4.block(), List.of(genre.block(), genre2.block(), genre4.block(), genre6.block())));
        Mono<Book> book3 = bookRepository.save(new Book("Ребекка", author2.block(), List.of(genre.block(), genre2.block(), genre3.block(), genre4.block())));
        Mono<Book> book4 = bookRepository.save(new Book("Преступление и наказание", author.block(), List.of(genre.block())));
    }


}
