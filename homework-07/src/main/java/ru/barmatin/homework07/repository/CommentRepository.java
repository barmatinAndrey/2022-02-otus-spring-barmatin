package ru.barmatin.homework07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.homework07.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByBookId(long bookId);

}
