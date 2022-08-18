package ru.barmatin.collectiveblog.service.post;

import ru.barmatin.collectiveblog.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAll();

    Optional<Post> getById(long id);

    void savePost(Post post);

}
