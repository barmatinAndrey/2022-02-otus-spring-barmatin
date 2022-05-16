package ru.barmatin.homework08.service.comment;

import ru.barmatin.homework08.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> getCommentById(String id);

    List<Comment> getCommentsByBookId(String bookId);

    void deleteCommentById(String id);

    void deleteCommentByBookId(String id);

    void saveComment(Comment comment);

}
