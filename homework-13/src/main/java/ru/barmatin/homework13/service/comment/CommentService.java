package ru.barmatin.homework13.service.comment;

import ru.barmatin.homework13.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> getCommentById(long id);

    List<String> getCommentsByBookId(long bookId);

    void deleteCommentById(long id);

    void saveComment(Comment comment);

}
