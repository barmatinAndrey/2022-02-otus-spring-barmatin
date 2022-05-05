package ru.barmatin.homework08.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import ru.barmatin.homework08.domain.Author;
import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.domain.Comment;
import ru.barmatin.homework08.domain.Genre;
import ru.barmatin.homework08.repository.AuthorRepository;
import ru.barmatin.homework08.repository.BookRepository;
import ru.barmatin.homework08.repository.CommentRepository;
import ru.barmatin.homework08.repository.GenreRepository;
import java.util.List;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "barmatin", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertBooks", author = "barmatin")
    public void insertBooks(AuthorRepository authorRepository, GenreRepository genreRepository,
                              BookRepository bookRepository, CommentRepository commentRepository) {
        Author author = authorRepository.save(new Author("Достоевский", "Федор", "Михайлович"));
        Author author1 = authorRepository.save(new Author("Маркес", "Габриэль Гарсия", ""));
        Author author2 = authorRepository.save(new Author("Дюморье", "Дафна", ""));
        Author author3 = authorRepository.save(new Author("Готтлиб", "Лори", ""));
        Author author4 = authorRepository.save(new Author("Тартт", "Дона", ""));

        Genre genre = genreRepository.save(new Genre("роман"));
        Genre genre1 = genreRepository.save(new Genre("магический реализм"));
        Genre genre2 = genreRepository.save(new Genre("триллер"));
        Genre genre3 = genreRepository.save(new Genre("детектив"));
        Genre genre4 = genreRepository.save(new Genre("трагедия"));
        Genre genre5 = genreRepository.save(new Genre("психология"));
        Genre genre6 = genreRepository.save(new Genre("фантастика"));

        Book book = bookRepository.save(new Book("Вы хотите поговорить об этом?", author3, List.of(genre5)));
        Book book1 = bookRepository.save(new Book("100 лет одиночества", author1, List.of(genre, genre1)));
        Book book2 = bookRepository.save(new Book("Щегол", author4, List.of(genre, genre2, genre4, genre6)));
        Book book3 = bookRepository.save(new Book("Ребекка", author2, List.of(genre, genre2, genre3, genre4)));
        Book book4 = bookRepository.save(new Book("Преступление и наказание", author, List.of(genre)));

        commentRepository.save(new Comment(book4.getId(), "Очень интересная книга"));
        commentRepository.save(new Comment(book4.getId(), "Это классика"));
    }


}
