package ru.barmatin.homework06.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.homework06.domain.Author;
import ru.barmatin.homework06.domain.Book;
import ru.barmatin.homework06.domain.Comment;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Репозиторий для работы с комментариями")
@DataJpaTest
@Import(CommentRepositoryJpa.class)
class CommentRepositoryJpaTest {

    @Autowired
    private CommentRepositoryJpa commentRepositoryJpa;

    @DisplayName("возвращает комментарий по id")
    @Test
    void getCommentById() {
        assertThat(commentRepositoryJpa.getCommentById(1).getText()).isEqualTo("Очень интересная книга");
    }

    @DisplayName("возвращает все комментарии для книги")
    @Test
    void getAllByBookId() {
        List<Comment> commentList = commentRepositoryJpa.getAllByBookId(5);
        assertThat(commentList.get(0).getText()).isEqualTo("Очень интересная книга");
        assertThat(commentList.get(1).getText()).isEqualTo("Это классика");
    }

    @DisplayName("удаляет комментарий по id")
    @Test
    void deleteById() {
        commentRepositoryJpa.deleteById(1);
        assertThat(commentRepositoryJpa.getAllByBookId(5).size()).isEqualTo(1);
    }

    @DisplayName("добавляет комментарий")
    @Test
    void insert() {
        int commentCountBeforeInsert = commentRepositoryJpa.getAllByBookId(5).size();
        Comment comment = new Comment(0, new Book(5, "", new Author(0, "", "", ""),
                new ArrayList<>()), "Новый комментарий");
        commentRepositoryJpa.insert(comment);
        int commentCountAfterInsert = commentRepositoryJpa.getAllByBookId(5).size();
        assertThat(commentCountAfterInsert).isEqualTo(commentCountBeforeInsert+1);
    }

    @DisplayName("изменяет комментарий")
    @Test
    void update() {
        Comment comment = new Comment(1, new Book(5, "", new Author(0, "", "", ""),
                new ArrayList<>()), "Новый комментарий");
        commentRepositoryJpa.update(comment);
        assertThat(commentRepositoryJpa.getCommentById(1).getText()).isEqualTo("Новый комментарий");
    }
}