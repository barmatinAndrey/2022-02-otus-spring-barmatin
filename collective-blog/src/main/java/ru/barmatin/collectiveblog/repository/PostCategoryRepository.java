package ru.barmatin.collectiveblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.barmatin.collectiveblog.domain.PostCategory;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
}
