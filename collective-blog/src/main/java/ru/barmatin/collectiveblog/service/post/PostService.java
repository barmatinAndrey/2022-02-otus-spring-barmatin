package ru.barmatin.collectiveblog.service.post;

import ru.barmatin.collectiveblog.domain.Post;
import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post getById(long id);

    void savePost(Post post);

}
