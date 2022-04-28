package ru.barmatin.homework06.service.comment;

import ru.barmatin.homework06.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment getCommentById(long id);

    List<Comment> getCommentsByBookId(long bookId);

    void deleteCommentById(long id);

    void addNewComment(Comment comment);

    void editComment(Comment comment);
}
