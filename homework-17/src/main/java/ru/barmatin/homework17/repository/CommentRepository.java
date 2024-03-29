package ru.barmatin.homework17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.barmatin.homework17.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c.text from Comment c where c.book.id = :bookId")
    List<String> findAllTextByBookId(@Param("bookId") long bookId);

}
