package ru.barmatin.homework05.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework05.dao.ext.BookGenreRelation;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dao для работы с книгами")
@JdbcTest
@Import({BookDaoJdbc.class, AuthorDaoJdbc.class, GenreDaoJdbc.class})

class BookDaoJdbcTest {
    @Autowired
    private BookDaoJdbc bookDao;

    @DisplayName("возвращает книгу по id")
    @Test
    void getBookById() {
        Book book = bookDao.getBookById(2);
        assertThat(book.getName()).isEqualTo("100 лет одиночества");
    }

    @DisplayName("возвращает книги в правильном порядке")
    @Test
    void getAll() {
        Book book = bookDao.getAll().get(0);
        assertThat(book.getName()).isEqualTo("100 лет одиночества");
    }

    @DisplayName("удаляет книгу по id")
    @Test
    void deleteById() {
        bookDao.deleteById(1);
        assertThat(bookDao.getAll().size()).isEqualTo(4);
    }

    @DisplayName("добавляет книгу в БД")
    @Test
    void bookInsert() {
        Book book = new Book(6, "Идиот", new Author(1, "", "", ""), new ArrayList<>());
        int bookCountBeforeInsert = bookDao.getAll().size();
        bookDao.insert(book);
        int bookCountAfterInsert = bookDao.getAll().size();
        assertThat(bookCountAfterInsert).isEqualTo(bookCountBeforeInsert+1);
    }

    @DisplayName("изменяет книгу")
    @Test
    void bookUpdate() {
        Book book = new Book(5, "Адвокат Дьявола", new Author(1, "", "", ""), new ArrayList<>());
        bookDao.update(book);
        assertThat(bookDao.getBookById(5).getName()).isEqualTo(book.getName());
    }
}