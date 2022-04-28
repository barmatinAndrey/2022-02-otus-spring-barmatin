package ru.barmatin.homework06.repository;

import ru.barmatin.homework06.domain.Comment;

import java.util.List;

public interface CommentRepository {

    Comment getCommentById(long id);

    List<Comment> getAllByBookId(long bookId);

    void deleteById(long id);

    void insert(Comment comment);

    void update(Comment comment);
}
