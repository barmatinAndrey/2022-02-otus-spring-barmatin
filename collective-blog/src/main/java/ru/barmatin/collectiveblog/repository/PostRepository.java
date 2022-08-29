package ru.barmatin.collectiveblog.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.collectiveblog.domain.Post;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(attributePaths = {"blogUser", "postCategory"})
    Post findById(long id);

    @EntityGraph(attributePaths = {"blogUser", "postCategory"})
    List<Post> findAllByIsVisibleOrderByPostDateDesc(boolean isVisible);

    @EntityGraph(attributePaths = {"blogUser", "postCategory"})
    List<Post> findAllByPostCategoryIdOrderByPostDateDesc(long id);

    @EntityGraph(attributePaths = {"blogUser", "postCategory"})
    List<Post> findAllByPostTagListNameOrderByPostDateDesc(String name);

}
