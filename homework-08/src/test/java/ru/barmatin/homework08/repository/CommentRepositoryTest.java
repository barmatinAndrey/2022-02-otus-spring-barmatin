package ru.barmatin.homework08.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.domain.Comment;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class CommentRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void findAllByBookId() {
        Book book = bookRepository.findAllByName("Преступление и наказание");
        List<Comment> commentList = commentRepository.findAllByBookId(book.getId());
        assertThat(commentList).hasSize(2).extracting(Comment::getText).contains("Очень интересная книга", "Это классика");
    }

}