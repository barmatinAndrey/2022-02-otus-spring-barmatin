package ru.barmatin.homework07.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.barmatin.homework07.domain.Author;
import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.domain.Comment;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void findAllByBookId() {
        List<Comment> commentList = commentRepository.findAllByBookId(5);
        assertThat(commentList.size()).isEqualTo(2);
    }

    @Test
    void addNewComment() {
        Book book = new Book(5, "", new Author(0, "", "", ""), new ArrayList<>());
        long commentId = (long)em.persistAndGetId(new Comment(0, book, "Тестовый комментарий"));
        assertThat(em.find(Comment.class, commentId).getText()).isEqualTo("Тестовый комментарий");
        assertThat(commentRepository.findAllByBookId(5).size()).isEqualTo(3);
    }

}