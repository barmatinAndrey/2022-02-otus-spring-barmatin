package ru.barmatin.collectiveblog.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.barmatin.collectiveblog.domain.PostComment;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

//    @Query("select t.content from PostComment t where t.post.id = :postId")
//    List<String> findAllContentByPostId(@Param("postId") long postId);

    @EntityGraph(attributePaths = {"post", "blogUser"})
    List<PostComment> findAllByPostId(@Param("postId") long postId);

}
