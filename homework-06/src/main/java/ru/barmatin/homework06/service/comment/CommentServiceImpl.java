package ru.barmatin.homework06.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.domain.Comment;
import ru.barmatin.homework06.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.getCommentById(id);
    }

    @Override
    public List<Comment> getCommentsByBookId(long bookId) {
        return commentRepository.getAllByBookId(bookId);
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void addNewComment(Comment comment) {
        commentRepository.insert(comment);
    }

    @Override
    public void editComment(Comment comment) {
        commentRepository.update(comment);
    }
}
