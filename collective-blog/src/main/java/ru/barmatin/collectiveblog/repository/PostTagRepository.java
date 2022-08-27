package ru.barmatin.collectiveblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.collectiveblog.domain.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
}
