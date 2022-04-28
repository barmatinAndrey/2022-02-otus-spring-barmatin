package ru.barmatin.homework07.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework07.domain.Comment;
import ru.barmatin.homework07.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Comment> getCommentById(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> getCommentsByBookId(long bookId) {
        return commentRepository.findAllByBookId(bookId);
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

}
