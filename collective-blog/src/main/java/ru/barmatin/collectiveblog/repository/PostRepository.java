package ru.barmatin.collectiveblog.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.collectiveblog.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(attributePaths = {"blogUser", "postCategory"})
    Optional<Post> findById(long id);
    @EntityGraph(attributePaths = {"blogUser", "postCategory"})
    List<Post> findAllByOrderByPostDate();

}
