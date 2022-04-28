package ru.barmatin.homework07.service.comment;

import ru.barmatin.homework07.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> getCommentById(long id);

    List<Comment> getCommentsByBookId(long bookId);

    void deleteCommentById(long id);

    void saveComment(Comment comment);

}
