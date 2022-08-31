package ru.barmatin.collectiveblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.barmatin.collectiveblog.domain.PostTag;

import java.util.Collection;
import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {

    @Query(value = "SELECT pt FROM PostTag pt WHERE pt.name IN :names")
    List<PostTag> findPostTagByNameList(@Param("names") Collection<String> names);

}
