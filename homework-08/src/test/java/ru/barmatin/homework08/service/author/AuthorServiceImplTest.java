package ru.barmatin.homework08.service.author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework08.domain.Author;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(AuthorServiceImpl.class)
class AuthorServiceImplTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void getAllAuthors() {
        List<Author> authorList = authorService.getAllAuthors();
        assertThat(authorList).hasSize(5).extracting(Author::getSurname)
                .containsExactlyInAnyOrder("Готтлиб", "Достоевский",
                        "Дюморье", "Маркес", "Тартт");
    }
}