package ru.barmatin.homework07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.barmatin.homework07.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.book.id = :bookId")
    List<Comment> findAllByBookId(@Param("bookId") long bookId);

}
