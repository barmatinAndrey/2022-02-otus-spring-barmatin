package ru.barmatin.homework11.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.barmatin.homework11.domain.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllByBookId(String bookId);

    void deleteAllByBookId(String bookId);

}
