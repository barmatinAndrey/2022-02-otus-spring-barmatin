package ru.barmatin.homework17.service.comment;

import ru.barmatin.homework17.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> getCommentById(long id);

    List<String> getCommentsByBookId(long bookId);

    void deleteCommentById(long id);

    void saveComment(Comment comment);

}
